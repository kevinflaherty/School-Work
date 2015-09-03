
/**
 * TrafficController simulates an TrafficController taking off/landing
 * @author Kevin Flaherty
 *
 */
public class TrafficController {
	   private int minutesTotal; // Minutes that it takes this TrafficController to complete takeoff/land
	   private int timeLeft;   // Minutes until this TrafficController is done

	                      
	   /**
	    * Constructor
	   * Initialize an TrafficController.
	   * @param s the number of minutes required for the TrafficController to complete its task
	   **/
	   public TrafficController(int s)
	   {
	       minutesTotal = s;
	       timeLeft = 0;
	   }


	   /**
	   * Determine whether this TrafficController is busy.
	   * @return true if the TrafficController is busy, otherwise false
	   **/   
	   public boolean isBusy( )
	   {
	      return (timeLeft > 0);
	   }
	 

	   /**
	   * Reduce the remaining time of the TrafficController by one minute.
	   **/
	   public void reduceRemainingTime( )
	   {
	      if (timeLeft > 0)
	         timeLeft--;
	   } 


	   /**
	   * Start a task for this controller.
	   * @precondition isBusy() is false
	   * @exception IllegalStateException
	   *   Indicates that this controller is busy.
	   **/
	   public void startTask( )
	   {
	      if(timeLeft > 0)
	         throw new IllegalStateException("Washer is already busy.");
	      timeLeft = minutesTotal;
	   }	   
}
