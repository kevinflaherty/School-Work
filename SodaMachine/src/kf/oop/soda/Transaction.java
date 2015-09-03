package kf.oop.soda;
import java.util.*;

/**
 * Transaction class represents the state that the SodaMachine is currently in.
 * @author Kevin Flaherty
 *
 */
public class Transaction {
	/**
	 * int ID is the Transaction identifier
	 * String name is the name of the transaction
	 * INIT_TID is the transaction ID for the InitTransaction
	 * ADMIN_TID is the transaction ID for the AdminTransaction
	 * SELECT_TID is the transaction ID for the SelectTransaction
	 * INPUT_TID is the transaction ID for the InputTransaction
	 * inputDescription contains the descriptions of all legalInputs
	 * legaInputs contains all the legal inputs for the current state
	 * SodaMachine is the SodaMachine that contains the Transaction
	 */
	protected int ID;
	protected String name = null;
	static public final int INIT_TID = 0;
	static public final int ADMIN_TID = 1;
	static public final int SELECT_TID = 2;
	static public final int INPUT_TID = 3;

	protected ArrayList<String> legalInputs = null;
	protected ArrayList<String> inputDescription = null;
	
	protected SodaMachine mSodaMachine;
	
	/**
	 * Constructor initializes legalInputs and mSodaMachine
	 * @param sm SodaMachine
	 */
	public Transaction(SodaMachine sm) {
		inputDescription = new ArrayList<String>();
		legalInputs = new ArrayList<String>();
		mSodaMachine = sm;
	}
	
	/**
	 * dummy constructor for searching transaction list
	 * @param tid legal transaction identifier
	 */
	public Transaction(int tid) {
	}
	
	/**
	 * Checks if the input is legal or not
	 * @param s User input
	 * @return boolean 
	 */
	public boolean isLegalInput(String s) {
		return legalInputs.contains(s);
	}
	
	/**
	 * Checks if this Transaction is equal to the one passed into it
	 * @param t Transaction
	 * @return boolean
	 */
	public Boolean equals(Transaction t){
		return(this == t);
	}
	
	/**
	 * Prints all the legal inputs for the Transaction
	 */
	public void displayLegalInputs() {
		for(int i = 0; i < legalInputs.size(); i++)
		{
			System.out.println(legalInputs.get(i) + " - " + inputDescription.get(i));
		}
	}
	
	/**
	 * Prints the Transaction name and legalInputs
	 */
	public void entry() {
		
		System.out.println("Entering "+ name);
		displayLegalInputs();
	}
	
	/**
	 * Implemented in subclasses
	 */
	public void run() {}	
}
