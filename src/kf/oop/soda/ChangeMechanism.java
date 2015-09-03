package kf.oop.soda;

/**
 * ChangeMechanism class represents the coin box in a Soda Machine.  Holds all the coins
 * entered and returns change to users.
 * @author Kevin Flaherty
 *
 */
public class ChangeMechanism {
	
	/**
	 * cust_q, cust_d, and cust_n are how many coins are in the change dispenser
	 * MAX_Q, MAX_D, and MAX_N are the maximum number each stack of coins can hold for quarters dimes and nickels respectively
	 * changeBox is the amount of money in the machine
	 * amountEntered is the amount a user has entered
	 */
	public int cust_q = 0, cust_d = 0 , cust_n = 0;
	public int MAX_Q = 3;
	public int MAX_D = 3;
	public int MAX_N = 3;
	private int changeBox = 0;
	private int amountEntered = 0;
	
	/**
	 * Constructor
	 * Initializes the ChangeMechanism to have 3 quarters, dimes and nickels.
	 * Empty changeBox and amountEntered;
	 */
	public ChangeMechanism() {
		resetAmountEntered();
		emptyCashBox();
		setCust_q(3);
		setCust_d(3);
		setCust_n(3);
	}
	
	public void resetAmountEntered() {
		amountEntered = 0;
	}
	
	/**
	 * Initializes the ChangeMechanism to have 3 quarters, dimes and nickels.
	 * Empties the cashBox and resets the amountEntered to 0.
	 */
	public void init() {
		resetAmountEntered();
	}
	
	/**
	 * Set the cashBox to 0
	 * @return String the amount inside the cashBox before being emptied
	 */
	public String getCashBox() {
		String s = String.valueOf(changeBox);
		if(s.length()==1)
			s = "0"+s;
		s = s.substring(0, s.length()-2) + "." + s.substring(s.length()-2, s.length());
		return s;
	}
	
	public void emptyCashBox() {
		changeBox = 0;
	}
	
	/**
	 * Accepts change into the change mechanism. If the coin return stacks aren't full then it fills them
	 * first and any extra money goes into the changeBox.
	 * Updates the amountEntered.
	 * @param c must be 5, 10 or 25 
	 */
	public void addChange(int c) {
		if(c == 5 && getCust_n() < MAX_N)
			setCust_n(getCust_n() + 1);
		else
			if(c == 10 && getCust_d() < MAX_D)
				setCust_d(getCust_d() + 1);
			else
				if(c == 25 && getCust_q() < MAX_Q)
					setCust_q(getCust_q() + 1);
				else
					changeBox += c;
		amountEntered += c;
	}
	
	/**
	 * Accepts change into the change mechanism as a String
	 * @param s String change to be added
	 */
	public void addChange(String s) {
		try{
			int c = Integer.parseInt(s);
			addChange(c);
		}
		catch(NumberFormatException e)	{
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Creates a string that shows how many coins are being returned and the total amount of change returned
	 * @param amountReturned 
	 * @return String 
	 */
	private String buildChangeString(int amountReturned) { 
		
		String emptyStack = "";
		int quarters = 0;
		int nickels = 0;
		int dimes = 0;
		int totalChange = 0;
		while(amountReturned-25 >= 0 && getCust_q() > 0)
		{
			if(getCust_q() > 0) {
				amountReturned = amountReturned-25;
				quarters++;
				setCust_q(getCust_q() - 1);
			}
			else {
				emptyStack += " Out of Quarters.";
				break;
			}
		}
		while(amountReturned-10 >= 0)
		{
			if(getCust_d() > 0) {
				amountReturned = amountReturned-10;
				dimes++;
				setCust_d(getCust_d() - 1);
			}
			else
			{
				emptyStack += " Out of Dimes.";
				break;
			}
		}
		while(amountReturned-5 >= 0)
		{
			if(getCust_n() > 0) {
				amountReturned = amountReturned-5;
				nickels++;
				setCust_n(getCust_n() - 1);
			}
			else {
				emptyStack +=" Out of Nickels.";
				break;
			}
				
		}
		
		resetAmountEntered();
		totalChange = quarters*25 + dimes*10 + nickels*5;
		return totalChange+" cents";
		//return  "Your change is " + totalChange + " cents. " + quarters +" Quarter(s), " + dimes + " Dime(s), and " + nickels + " Nickel(s). \n" + emptyStack;
		
	}
	
	/**
	 * method called to calculate the  amount of change coming back to the 
	 * machine user. Assumes coins have already been added.
	 * @param cost cost of current selection (Use 0 for lack of inventory)
	 * @return String
	 */
	public String getChange(int cost) {
		int change = amountEntered-cost;
		changeBox -= change;
		if(changeBox < 0)
			changeBox = 0;
		return buildChangeString(change);
	}
	
	/**
	 * Gets the amountEntered
	 * @return int amountEntered
	 */
	public int getAmountEntered () {
		return amountEntered;
	}

	public int getCust_d() {
		return cust_d;
	}

	public void setCust_d(int cust_d) {
		this.cust_d = cust_d;
	}

	public int getCust_n() {
		return cust_n;
	}

	public void setCust_n(int cust_n) {
		this.cust_n = cust_n;
	}

	public int getCust_q() {
		return cust_q;
	}

	public void setCust_q(int cust_q) {
		this.cust_q = cust_q;
	}
	
	
	
}
