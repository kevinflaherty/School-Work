package kf.oop.soda;

import java.util.Observable;

/**
 * InventoryItem class represents a soda type
 * @author Kevin Flaherty
 *
 */
public class InventoryItem extends Observable{

	/**
	 * ID is the numerical identifier of the item
	 * MAX_QUANTITY is the maximum number of items there can be
	 * name is the name of the item
	 * QIS is the quantity in stock and is not to exceed MAX_QUANTITY
	 * PRICE is the cost of the item
	 */
	private int ID = 0;
	private static final int MAX_QUANTITY = 3;
	private String name = null;
	private int QIS = 0;
	private final int PRICE = 75;
	
	/**
	 * Constructor sets ID, name and initialQIS.
	 * @param id ID
	 * @param n name
	 * @param initialQIS QIS
	 */
	public InventoryItem(int id, String n, int initialQIS) {
		ID = id;
		name = n;
		QIS = initialQIS;
	}
	
	/**
	 * Adds the quantity to QIS
	 * @param q quantity
	 */
	public void addToInventory(int q) {
		if(QIS + q <= MAX_QUANTITY)
			QIS += q;
		else 
			QIS = MAX_QUANTITY;
	}
	
	/**
	 * Fills the QIS to the maximum quantity
	 */
	public void addToInventory() {
		
		QIS = MAX_QUANTITY;
		notifyObservers();
	}
	
	/**
	 * Decreases the item QIS by 1
	 * @precondition QIS > 0
	 */
	public void decrementInventory() {
		QIS -= 1;
		if(QIS == 0)
			notifyObservers();
	}
	
	/**
	 * Gets the price of the item
	 * @return PRICE
	 */
	public int getPrice() {
		
		return PRICE;
	}
	
	/**
	 * Gets the name of the item
	 * @return name
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Gets the item ID
	 * @return ID
	 */
	public int getID()	{
		
		return ID;
	}
	
	/**
	 * Creates a string with the name of the soda and the QIS
	 * @return String
	 */
	public String toString() {
		
		return(name + " - " + QIS);
	}
	
	/**
	 * Checks if the given InventoryItem is equal to this InventoryItem
	 * @param io InventoryItem 
	 * @return boolean
	 */
	public boolean equals(InventoryItem io) {
		
		if(io.getName() == this.getName() || io.getID() == this.getID())
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the QIS
	 * @return QIS
	 */
	public int getQIS () {
		
		return QIS;
	}
}
