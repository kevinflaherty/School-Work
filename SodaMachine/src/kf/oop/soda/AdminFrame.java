package kf.oop.soda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * Admin Frame class displays the admin mode of the soda machine.
 * @author Kevin Flaherty
 *
 */
public class AdminFrame extends JFrame{
	
	public AdminFrame(Action action) {
		this.setTitle("Admin Mode");
		Dimension d = new Dimension(300,400);
		this.setPreferredSize(d);
		JPanel mainPanel = new JPanel(new GridLayout(4,1));
		
		JPanel returnPanel = new JPanel(new BorderLayout());
		returnPanel.add(new JLabel("Coin Return"),BorderLayout.NORTH);
		JPanel changePanel = new JPanel(new FlowLayout());
		ns = new JTextArea("3");
		ds = new JTextArea("3");
		qs = new JTextArea("3");
		changePanel.add(new JLabel("N"));
		changePanel.add(ns);
		changePanel.add(new JLabel("D"));
		changePanel.add(ds);
		changePanel.add(new JLabel("Q"));
		changePanel.add(qs);
		returnPanel.add(changePanel, BorderLayout.SOUTH);
		returnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel cashPanel = new JPanel(new BorderLayout());
		cashPanel.add(new JLabel("Cash Box"), BorderLayout.NORTH);
		JPanel totalPanel = new JPanel(new FlowLayout());
		totalPanel.add(new JLabel("Total:"));
		total = new JTextArea("0.00");
		totalPanel.add(total);
		totalPanel.add(new JLabel("  "));
		remove = new JButton("Remove");
		totalPanel.add(remove);
		cashPanel.add(totalPanel, BorderLayout.SOUTH);
		cashPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel inventoryPanel = new JPanel(new BorderLayout());
		inventoryPanel.add(new JLabel("Inventory"), BorderLayout.NORTH);
		table = new JTable(new InventoryTableModel());
		table.setGridColor(Color.DARK_GRAY);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		inventoryPanel.add(table,BorderLayout.SOUTH);
		
		new ButtonColumnCreator(table, action, 2);
		
		JPanel quitPanel = new JPanel(new FlowLayout());
		quit = new JButton("Quit");
		quitPanel.add(new JLabel("   "));
		quitPanel.add(quit);
		
		mainPanel.add(returnPanel);
		mainPanel.add(cashPanel);
		mainPanel.add(inventoryPanel);
		mainPanel.add(quitPanel);
		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(mainPanel);
	}
	
	public JTextArea ns;
	public JTextArea ds;
	public JTextArea qs;
	public JTextArea total;
	public JTable table;
	public JButton remove;
	public JButton quit;
}
