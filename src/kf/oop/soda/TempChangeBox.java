package kf.oop.soda;
/**
 * TempChangeBox class is used to hold the change before it enters the 
 * change mechanism in the case that the timer runs out and the coins need 
 * to be returned.
 * @author Kevin
 *
 */
public class TempChangeBox extends ChangeMechanism {
	private ChangeMechanism cm;
	
	public TempChangeBox(ChangeMechanism cm) {
		super();
		cust_n = 0;
		cust_d = 0;
		cust_q = 0;
		MAX_N = 100;
		MAX_D = 100;
		MAX_Q = 100;
		this.cm = cm;
	}
	
	public void resetTempBox() {
		cust_n = 0;
		cust_d = 0;
		cust_q = 0;
		resetAmountEntered();
		emptyCashBox();
	}
	
	/**
	 * Gets the change and puts the rest of the coins inside the change mechanism if
	 * a soda is purchased.
	 * @return
	 */
	public void deposit() {
		
			for(int i = 0; i < this.getCust_n();i++) {
				cm.addChange(5);
			}
			for(int i = 0; i < this.getCust_d();i++) {
				cm.addChange(10);
			}
			for(int i = 0; i < this.getCust_q();i++) {
				cm.addChange(25);
			}
			
		resetTempBox();
		
	}
}
