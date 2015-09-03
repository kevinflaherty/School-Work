package kf.oop.soda;

/**
 * InitTransaction class is the beginning state of a SodaMachine
 * @author Kevin Flaherty
 *
 */

public class InitTransaction extends Transaction{
	
	/**
	 * Constructor sets name and ID
	 * @param sm SodaMachine
	 */
	public InitTransaction(SodaMachine sm) {
		super(sm);
		name = "Initial State";
		ID = INIT_TID;
		}
	
	/**
	 * Prints name of state
	 */
	public void entry() {
		super.entry();
	}
	
	/**
	 * Calls entry and changes state to InputTransaction
	 */
	public void run() {
		entry();
		mSodaMachine.initMachine();
		mSodaMachine.advanceTransaction(INPUT_TID);
	}
}
