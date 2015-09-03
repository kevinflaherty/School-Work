package kf.oop.soda;

/**
 * SelectTransaction class is the select state for the soda machine. Used for when a user has made a soda selection
 * or an admin refills a soda.
 * @author Kevin Flaherty
 *
 */

public class SelectTransaction extends Transaction {

	/**
	 * Constructor that sets the name of the transaction
	 * @param sm SodaMachine
	 */
	public SelectTransaction(SodaMachine sm ) {
		super(sm);
		name = "Select State";
	}
	
	/**
	 * Prints which state the machine is in
	 */
	public void entry() {
		super.entry();
	}
	
	/**
	 * Processes the selection and then changes the state to initial transaction
	 */
	public void run() {
		entry();
		mSodaMachine.processSelection();
		mSodaMachine.advanceTransaction(INIT_TID);
	}
}
