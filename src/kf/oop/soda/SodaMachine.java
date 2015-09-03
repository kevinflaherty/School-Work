package kf.oop.soda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * SodaMachine class simulates a soda machine.  
 * @author Kevin Flaherty
 *
 */
public class SodaMachine implements Observer{

	/**
	 * transaction is the current transaction that is running
	 * transactions is an arraylist of all the Transactions
	 * scan is for user input, all user input is done in this class
	 * inventory contains the sodas
	 * changeMechanism handles the money needed in the SodaMachine
	 * latestSelection is used to store the last selection made to process the selection
	 */
	public static Transaction transaction;
	private static ArrayList<Transaction> transactions;
	private Scanner scan;
	private Inventory inventory = null;
	private ChangeMechanism changeMechanism;
	private String latestSelection = null;
	private AdminFrame adminFrame;
	private SodaFrame mainFrame;
	private boolean clockStarted;
	private Timer t;
	private TempChangeBox tempChange;
	/**
	 * Constructor that initializes fields 
	 */
	public SodaMachine() {
		transactions = new ArrayList<Transaction>();
		inventory = new Inventory();
		changeMechanism = new ChangeMechanism();
		scan = new Scanner(System.in);
		inventory.addObserver(this);
		clockStarted = false;
		tempChange = new TempChangeBox(changeMechanism);
		initMachine();
		t = new Timer(30000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.total.setText(" ");
				mainFrame.change.setText(tempChange.getChange(0));
			}
		});
		transaction = new Transaction(this);
		mainFrame = new SodaFrame();
		mainFrame.pack();
		Action addInventory = new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        inventory.getInventoryItem(modelRow+"").addToInventory();
		        adminFrame.table.getModel().setValueAt(inventory.getInventoryItem(modelRow+"").getQIS(), modelRow, 1);
		        adminFrame.table.getModel().setValueAt(" ", modelRow, 2);
			}
		};
		adminFrame = new AdminFrame(addInventory);
		adminFrame.pack();
		
		mainFrame.coke.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				latestSelection = "s0";
				processSelection();
			}
		});
		mainFrame.orange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				latestSelection = "s1";
				processSelection();
			}
		});
		mainFrame.sprite.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				latestSelection = "s2";
				processSelection();
			}
		});
		mainFrame.ginger.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				latestSelection = "s3";
				processSelection();
			}
		});
		
		mainFrame.nickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempChange.addChange("5");
				mainFrame.total.setText(tempChange.getAmountEntered()+" cents");
				if(!clockStarted) {
					clockStarted = true;
					t.start();
				}
			}
		});
		mainFrame.dime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempChange.addChange("10");
				mainFrame.total.setText(tempChange.getAmountEntered()+" cents");
				if(!clockStarted) {
					clockStarted = true;
					t.start();
				}
			}
		});
		mainFrame.quarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tempChange.addChange("25");
				mainFrame.total.setText(tempChange.getAmountEntered()+" cents");
				if(!clockStarted) {
					clockStarted = true;
					t.start();
				}
			}
		});
		mainFrame.enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.setVisible(false);
				adminFrame.setVisible(true);
				adminFrame.ds.setText(""+changeMechanism.getCust_d());
				adminFrame.ns.setText(""+changeMechanism.getCust_n());
				adminFrame.qs.setText(""+changeMechanism.getCust_q());
				adminFrame.total.setText(changeMechanism.getCashBox());
			}
		});
		
		// AdminMode Functionality
		adminFrame.quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminFrame.setVisible(false);
				mainFrame.setVisible(true);
			}
		});
		
		adminFrame.remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMechanism.emptyCashBox();
				adminFrame.total.setText(changeMechanism.getCashBox());
				changeMechanism.resetAmountEntered();
				mainFrame.total.setText(changeMechanism.getAmountEntered()+" cents");
			}
		});
		
		mainFrame.setVisible(true);

	}
	
	
	/**
	 * Processes a user's soda selection to purchase or the 
	 * admin's choice of soda to refill.
	 * Prints the results.
	 */
	public void  processSelection() {
		String s = ""+latestSelection.charAt(1);
		int sel = Integer.parseInt(s);
		char type = latestSelection.charAt(0);
		int amountEntered = tempChange.getAmountEntered();
		if(type == 's')
			if(!inventory.insufficientFunds(sel, amountEntered))
			{
				String selection = inventory.getSelection(sel);
				if(!selection.equals(" "))
				{
					tempChange.deposit();
					mainFrame.selected.setText(selection);
					mainFrame.change.setText(changeMechanism.getChange(75));
					mainFrame.total.setText(" ");
					adminFrame.table.getModel().setValueAt(inventory.getInventoryItem(sel+"").getQIS(), sel, 1);
					mainFrame.oosTextPane.setText(inventory.getInventoryItem(sel+"").getQIS()+" in stock.");
					adminFrame.table.getModel().setValueAt("Yes", sel, 2);
	
				}
				else {
					mainFrame.oosTextPane.setText("Out of Stock");
					mainFrame.change.setText(tempChange.getAmountEntered() + " cents");
					tempChange.resetTempBox();
				}
					
			}
			else {
				mainFrame.change.setText(tempChange.getAmountEntered() +" cents");
				tempChange.resetTempBox();
				mainFrame.selected.setText("Insufficient Funds");
			}
		clockStarted = false;
		t.stop();
	}
	
	/**
	 * Empties transactions and then refills it with new Transactions
	 */
	public void resetTransaction() {
		transactions.clear();
		addTransactions();
	}
	
	/**
	 * Returns current transaction
	 * @param t transaction number
	 * @return Transaction
	 */
	public Transaction getTransaction(int t) {
		return transactions.get(t);
	}
	
	/**
	 * Sets transaction field to the transaction of the TID passed
	 * @param tid Transaction ID to move to
	 */
	public void advanceTransaction(int tid) {
		transaction = transactions.get(tid);
	}
	
	/**
	 * Sets latestSelection to the string passed
	 * @param s selection
	 */
	public void saveSelection(String s) {
		latestSelection = s;
	}
	
	/**
	 * Adds one of each of the 4 different sub Transaction classes to transactions
	 */
	public void addTransactions() {
		
		transactions.add(new InitTransaction(this));
		transactions.add(new AdminTransaction(this));
		transactions.add(new SelectTransaction(this));
		transactions.add(new InputTransaction(this));

	}
	/**
	 * Reads user input from terminal and checks it against legal inputs
	 * @param args - the legal inputs in this state
	 * @return input string if legal; otherwise it returns white space.
	 * 
	 */
	public String consumeInput(ArrayList<String> args) {
		String input = scan.nextLine();
		if(args.contains(input))
			return input;
		else
			return " ";
	}
	
	/**
	 * Adds change to changeMechanism
	 * @param s int amount of change to add
	 */
	public void accumulateChange(String s) {
		changeMechanism.addChange(s);
		mainFrame.total.setText(changeMechanism.getAmountEntered()+" cents");
		//System.out.println("You have entered: " + changeMechanism.getAmountEntered() + " cents.");
	}
		
	/**
	 *Initializes changeMechanism
	 */
	public void initMachine() {
		changeMechanism.resetAmountEntered();
	}
	
	/**
	 * Prints the contents of Inventory
	 */
	public void displayMachineInfo() {
		//System.out.println(inventory.toString());
	}
	/**
	 * Method used by to retrieve money from changeMechanism.
	 * Prints how much money was returned.
	 */
	public void removeMachineReceipts() {
		System.out.println("Retrieving " + changeMechanism.getCashBox() + " cents.");
	}
	
	/**
	 * Refills soda when admin makes a selection
	 * @param s r0,r1,r2,or r3
	 */
	public void addToInventory(String s) {
		String sel = ""+s.charAt(1);
		inventory.updateInventory(sel);
	}
	
	public void update(Observable obs, Object obj) {
		for(int i = 0; i > 4; i++) {
			if(inventory.getInventoryItem(i+"").getQIS() == 0) {
				switch(i)	{
				case 0: mainFrame.coke.setEnabled(false);
				case 1: mainFrame.orange.setEnabled(false);
				case 2: mainFrame.sprite.setEnabled(false);
				case 3: mainFrame.ginger.setEnabled(false);
				}
			}
			else {
				switch(i)	{
				case 0: mainFrame.coke.setEnabled(true);
				case 1: mainFrame.orange.setEnabled(true);
				case 2: mainFrame.sprite.setEnabled(true);
				case 3: mainFrame.ginger.setEnabled(true);
				}
				
			}
		}
	}
	
	
	/**
	 * main method contains a loop that runs the current transaction
	 * transaction starts at InitialTransaction
	 * @param args Command line arguments not used
	 */
	public static void main(String[] args) {
		SodaMachine sm = new SodaMachine();
		sm.addTransactions();
		

	}

}
