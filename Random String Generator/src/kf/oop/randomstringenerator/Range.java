package kf.oop.randomstringenerator;

import java.util.ArrayList;
import java.util.Random;


/**
 * Range class is used by RandomStringGenerator to store sets of characters and get random characters
 * @author Kevin Flaherty
 *
 */
public class Range {
	
	/**
	 * Field range is an ArrayList of characters that can be generated 
	 */
	private ArrayList<Character> range = new ArrayList<Character>();
	
	/**
	 * Default constructor
	 */
	public Range() { }
	
	/**
	 * Constructor
	 * Sets the range field to the ArrayList that the Range is initialized with
	 * @param r ArrayList of characters to go into the range
	 */
	public Range(ArrayList<Character> r)
	{
		setRange(r);
	}
	
	/**
	 * Method getRandomCharacter is used to get a random char within the Range
	 * @return Random char within the range
	 */
	public char getRandomCharacter()
	{
		Random rand = new Random();
		char c = getRange().get(rand.nextInt(getRange().size()));
		return c;
	}

	/**
	 * getRange method return range attribute
	 * @return ArrayList range
	 */
	public ArrayList<Character> getRange() {
		return range;
	}
	
	/**
	 * setRange method sets the range attribute
	 */
	public void setRange(ArrayList<Character> range) {
		this.range = range;
	}
	
}
