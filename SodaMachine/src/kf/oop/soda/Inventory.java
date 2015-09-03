package kf.oop.soda;

import java.util.*;

/**
 * Inventory class contains all of the sodas that the SodaMachine has in stock
 * @author Kevin Flaherty
 *
 */
public class Inventory extends Observable implements Observer{

	/**
	 * Constant Strings for the names of the sodas.
	 */
	public static String COLA= "cola";
	public static String ORANGE= "orange";
	public static String SPRITE= "sprite";
	public static String GINGER_ALE= "ginger ale";
	public static String DIET_COLA= "diet cola";
	
	//ArrayList containing the InventoryItem(sodas)
	private ArrayList<InventoryItem> contents = null;
	
	/**
	 * Constructor initializes contents and adds the different sodas with a full stock of each
	 */
	public Inventory() {
		contents = new ArrayList<InventoryItem>();
		
		contents.add(new InventoryItem(0, COLA, 3));
		contents.add(new InventoryItem(1, ORANGE, 3));
		contents.add(new InventoryItem(2, SPRITE, 3));
		contents.add(new InventoryItem(3, GINGER_ALE, 3));
		contents.add(new InventoryItem(4, DIET_COLA, 3));
		for(int i = 0; i < contents.size(); i++) {
			contents.get(i).addObserver(this);
		}
	}
	
	/**
	 * Adds the quantity passed to the InventoryItem specified
	 * @param id ID of the InventoryItem
	 * @param q Quantity to add
	 */
	public void addToInventory(int id, int q ) {
	
		for(int i = 0; i < contents.size(); i++)
		{
			if(contents.get(i).getID() == id)
				contents.get(i).addToInventory(q);
		}
	}
	
	public void update(Observable obs, Object obj) {
		notifyObservers();
	}
	/**
	 * Adds the quantity passed to the InventoryItem specified
	 * @param n Name of InventoryItem
	 * @param q Quantity to add
	 */
	public void addToInventory(String  n, int q ) {
		
		for(int i = 0; i < contents.size(); i++)
		{
			if(contents.get(i).getName() == n)
				contents.get(i).addToInventory(q);
		}
	}
	
	/**
	 * Returns a string of all the names of the InventoryItems in the Inventory
	 * @return String
	 */
	public String toString() {
		
		String s = "";
		for(int i = 0; i < contents.size(); i++)
		{
			s += contents.get(i).getName() + " - QIS: " + contents.get(i).getQIS() + "\n";
		}
		
		return s;
	}
	
	/**
	 * Gets InventoryItem
	 * @param s String ID of the InventoryItem 
	 * @return InventoryItem
	 */
	public InventoryItem getInventoryItem(String s) {
		return contents.get(Integer.parseInt(s));
		
	}
	
	/**
	 * Checks if the amountEntered is not enough to purchase the item
	 * @param item ID of InventoryItem
	 * @param amountEntered
	 * @return boolean True is insufficient, False otherwise
	 */
	public boolean insufficientFunds(int item, int amountEntered) {
		return(contents.get(item).getPrice() > amountEntered);
	}
	
	/**
	 * Returns name of item
	 * @param i ID of item
	 * @return String name of item
	 */
	public String getItemName(int i) {
		return contents.get(i).getName();
	}
	
	/**
	 * Decrements the item in the Inventroy and returns the InventoryItem
	 * @param i ID of InventoryItem
	 * @return InventoryItem
	 */
	private InventoryItem getItem(int i) {
		return contents.get(i);
		
	}
	
	/**
	 * Checks if the item is out of stock
	 * @param itemID
	 * @return boolean
	 */
	public boolean outOfStock(int itemID) {
		return(contents.get(itemID).getQIS() == 0);
	}
	
	/**
	 * Gets the price of the selection
	 * @param selection
	 * @return int price of item
	 */
	public int getSelectionCost(int selection) {
		return this.getItem(selection).getPrice();
	}
	
	/**
	 * Gets the selection 
	 * @param selection
	 * @return String selection name or white space if selection is out of stock
	 */
	public String getSelection(int selection) {
		if(!outOfStock(selection))
		{
			contents.get(selection).decrementInventory();
			return this.getItem(selection).getName();
		}
		else
			return " ";
	}
	
	/**
	 * Refills the selected InventoryItem
	 * @param s InventoryItem ID
	 * 
	 */
	public void updateInventory(String s) {
		int sel = Integer.parseInt(s);
		contents.get(sel).addToInventory();
	}
}
