import java.util.*;
/**
 * Airport class simulates an Airport with one runway/TrafficController
 * @author Kevin Flaherty
 * CPS 3 Lab #3
 */
public class Airport {

	/**
	 * main method initializes variables and calls simulateAirport
	 * @param args
	 */
	public static void main(String[] args) {
		final int landTime = 4;
		final int takeTime = 2;
		final double average = 0.05;
		final int totalTime = 6000;
		final int maxWaitTime = 2;
		
		simulateAirport(landTime, takeTime, average, totalTime, maxWaitTime);
	}
	
	/**
	 * Simulates an airport with one runway
	 * All landing have priority over departures 
	 * Prints the initial data and then calculates and prints wait times and number of crashes
	 * @param landTime Time it takes to land a plane
	 * @param takeTime Time it takes to take off
	 * @param average Probability that a plane will arrive/depart
	 * @param totalTime The total running time
	 * @param maxWaitTime Maximum wait time that a plane can wait to land before crashing
	 */
	public static void simulateAirport(int landTime, int takeTime, double average, int totalTime, int maxWaitTime) {
		Queue<Integer> arrivals = new LinkedList<Integer>();
		Queue<Integer> departures = new LinkedList<Integer>();
		BooleanSource probability = new BooleanSource(average);
		TrafficController lander = new TrafficController(landTime);
		TrafficController departer = new TrafficController(takeTime);
		Averager landWaitTimes = new Averager();
		Averager departWaitTimes = new Averager();
		int landNext, departNext;
		int currentMinute;
		int crashed = 0;
		
		System.out.println("Amount of minutes to land: " + landTime);
		System.out.println("Amount of minutes to take off: " + takeTime);
		System.out.println("Probability of arrival during a minute: " + average);
		System.out.println("Average amount of time between planes to land: " + 1/average);
		System.out.println("Probability of departure during a minute: " + average);
		System.out.println("Average amount of time between planes to depart: " + 1/average);
		System.out.println("Maximum amount of time in the air before crashing: " + maxWaitTime);
		System.out.println("Total simulation minutes: " + totalTime + "\n");
		
		for(currentMinute = 0; currentMinute < totalTime; currentMinute++) {
			if(probability.query())
			{
				arrivals.add(currentMinute);
			}
			
			if(probability.query())
			{
				departures.add(currentMinute);
			}
			
			if(!lander.isBusy() && !departer.isBusy()) {
				if(!arrivals.isEmpty()) {
					landNext = arrivals.remove();
					if(currentMinute - landNext > maxWaitTime) {
						crashed++;
					}
					else {
						landWaitTimes.addNumber(currentMinute - landNext);
						lander.startTask();
					}
				}	
				else
					if(!departures.isEmpty()) {
						departNext = departures.remove();
						departWaitTimes.addNumber(currentMinute - departNext);
						departer.startTask();
					}	
			}
				
				lander.reduceRemainingTime();
				departer.reduceRemainingTime();
		}
		System.out.println("Number of planes taken off: " + departWaitTimes.howManyNumbers());
		System.out.println("Number of planes landed: " + landWaitTimes.howManyNumbers());
		System.out.println("Number of planes crashed: " + crashed);
		System.out.println("Average waiting time for taking off: " + departWaitTimes.average() + " minutes");
		System.out.println("Average waiting time for landing: " + landWaitTimes.average() + " minutes");
	}

}
