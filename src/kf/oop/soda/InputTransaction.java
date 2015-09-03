package kf.oop.soda;

/**
 * InputTransaction is the input state for the SodaMachine.  Users can input coins, select drinks, or administrators 
 * can access the admin mode from this state.
 * @author Kevin Flaherty
 *
 */
public class InputTransaction extends Transaction {
	
	/**
	 * Constructor that adds legalInputs/inputDescriptions and sets the name/ID
	 * @param sm SodaMachine
	 */
	public InputTransaction(SodaMachine sm) {
		super(sm);
		name = "Input State";
		ID = INPUT_TID;
		legalInputs.add("a");
		legalInputs.add("5");
		legalInputs.add("10");
		legalInputs.add("25");
		legalInputs.add("s0");
		legalInputs.add("s1");
		legalInputs.add("s2");
		legalInputs.add("s3");
		legalInputs.add("s4");
		
		inputDescription.add(" Enter Admin Mode");
		inputDescription.add(" Insert Nickel");
		inputDescription.add("Insert Dime");
		inputDescription.add("Insert Quarter");
		inputDescription.add("Select Cola");
		inputDescription.add("Select Orange");
		inputDescription.add("Select Sprite");
		inputDescription.add("Select Ginger Ale");
		inputDescription.add("Select Diet Cola");
	}
	
	/**
	 * Prints the name of the Transaction and legalInputs
	 */
	public void entry() {
		System.out.println("Entering "+ name);
		System.out.println("Enter one of the following commands:");
		displayLegalInputs();
		System.out.print("Select: ");
	}
	
	/**
	 * Takes user input and updates transaction
	 */
	public void run() {
		entry();
		String input = mSodaMachine.consumeInput(legalInputs);
		switch (input) 
		{
			case "a":	mSodaMachine.advanceTransaction(ADMIN_TID);
						break;
						
			case "5":	case "10":	
			case "25":	
						mSodaMachine.accumulateChange(input);
						break;
						
			case "s0":	case "s1":
			case "s2":	case "s3":
			case "s4":	
						mSodaMachine.saveSelection(input);
						mSodaMachine.advanceTransaction(SELECT_TID);
						break;
						
			default: 	System.out.println("Invalid Input");	
						break;
		}
	}
}
