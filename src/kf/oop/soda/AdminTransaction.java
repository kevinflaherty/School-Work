package kf.oop.soda;
/**
 * AdminTransaction class is the admin state for the soda machine.
 * @author Kevin Flaherty
 *
 */
public class AdminTransaction extends Transaction {
	
	/**
	 * Constructor requires a SodaMachine object and adds legal inputs.
	 * @param sm SodaMachine
	 */
	public AdminTransaction(SodaMachine sm) {
		super(sm);
		name = "Admin State";
		ID = ADMIN_TID;
		legalInputs.add("q");
		legalInputs.add("R");
		legalInputs.add("r0");
		legalInputs.add("r1");
		legalInputs.add("r2");
		legalInputs.add("r3");
		legalInputs.add("r4");	
		
		inputDescription.add(" Quit Admin Mode");
		inputDescription.add(" Retrieve Money from Cash Box");
		inputDescription.add("Refill Cola");
		inputDescription.add("Refill Orange");
		inputDescription.add("Refill Sprite");
		inputDescription.add("Refill Ginger Ale");
		inputDescription.add("Refill Diet Cola");
	}
	
	/**
	 * Prints which state the machine is in, the Inventory stock, and legalInputs
	 */
	public void entry() {
		System.out.println("Entering "+ name);
		mSodaMachine.displayMachineInfo();
		System.out.println("Enter one of the following commands:");
		displayLegalInputs();
		System.out.print("Select: ");
	}
	
	/**
	 * Takes the user input and changes state
	 */
	public void run() {
		entry();
		String input = mSodaMachine.consumeInput(legalInputs);
		switch (input) 
		{
			case "q":	mSodaMachine.advanceTransaction(INIT_TID);
						break;
						
			case "R":	mSodaMachine.removeMachineReceipts();
						break;
						
			case "r0":	case "r1":
			case "r2":	case "r3":
			case "r4":	
						mSodaMachine.saveSelection(input);
						mSodaMachine.addToInventory(input);
						mSodaMachine.advanceTransaction(SELECT_TID);
						break;
						
			default: 	System.out.println("Invalid Input");	
						break;
		}
	}
}
