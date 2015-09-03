package kf.oop.randomstringenerator;
import java.util.*;

/**
 * RandomStringGenerator class generates random strings 
 * within given range of characters.
 * @author Kevin Flaherty
 */

public class RandomStringGenerator {
	/**
	 * ranges field is an ArrayList that contains all the Ranges in a generator object
	 */
	private ArrayList<Range> ranges = new ArrayList<Range>();
	
	/**
	 * Default constructor
	 */
	
	public RandomStringGenerator()	{ }
	
	/**
	 * addRange method used to add a new range to ranges
	 * @param start The first character of the range
	 * @param end The last character of the range
	 */
	
	public void addRange(char start, char end)
	{
		ArrayList<Character> rangeList = new ArrayList<Character>();
		int c = (int)start;
		int finish = (int)end;
		
		while(c <= finish)
		{
			rangeList.add((char)c);
			c++;
		}
		Range r = new Range(rangeList);
		ranges.add(r);
	}
	
	/**
	 * getRangeIndex method chooses a random Range within ranges field
	 * @return An index of a random Range
	 */
	private int getRangeIndex()
	{
		int x = 0;
		Random rand = new Random();
		x = rand.nextInt(ranges.size());
		return x;
	}
	
	/**
	 * nextString method creates a random string
	 * @param length The length that the string should be
	 * @return The string that is generated
	 */
	public String nextString(int length)
	{
		Random rand = new Random();
		Range r = new Range();
		String s = "";
		for(int i = 0; i < length; i++)
		{
			r = ranges.get(getRangeIndex());
			s+= r.getRange().get(rand.nextInt(r.getRange().size()));
		}
		return s;
	}
	
	/**
	 * nextString method creates a random String.
	 * @param s String with the characters 'c'(lowercase letter), 'C'(uppercase letter), or 'd'(integer). 
	 * @return The string that is generated
	 */
	
	public String nextString(String s)
	{
		ArrayList<Character> allChars = getAllCharacters();
		ArrayList<Character> lowerCaseChars = new ArrayList<Character>();
		ArrayList<Character> upperCaseChars = new ArrayList<Character>();
		ArrayList<Character> numbers = new ArrayList<Character>();
		Character c = null;
		String randomString = "";
		Random rand = new Random();
		String errorMessage = "";
		boolean notInRange = false;
		
		for(int i=0; i < allChars.size(); i++)
		{
			int x = (int)allChars.get(i);
			
			if(97 <= x && x <= 122)
				lowerCaseChars.add((char)x);
			
			if(65 <= x && x <= 90)
				upperCaseChars.add((char)x);
			
			if(48 <= x && x <= 57)
				numbers.add((char)x);
		}
		
		for(int i=0; i < s.length(); i++)
		{
			if(s.charAt(i) == 'c')
			{
				try
				{
					c = lowerCaseChars.get(rand.nextInt(lowerCaseChars.size()));
				}
				catch(IllegalArgumentException e)	
				{ 
					errorMessage = "No lowercase letters in generator ranges.";
					notInRange = true;
				}
				randomString += c;
			}
			else 
				if(s.charAt(i) == 'C')
				{
					try
					{
						c = upperCaseChars.get(rand.nextInt(upperCaseChars.size()));
					}
					catch(IllegalArgumentException e)	
					{
						errorMessage = "No uppercase letters in generator ranges.";
						notInRange = true;
					}
					randomString += c;
				}
				else 
					if(s.charAt(i) == 'd')
					{
						try
						{
							c = numbers.get(rand.nextInt(numbers.size()));
						}
						catch(IllegalArgumentException e)	
						{	 
							errorMessage = "No integers in generator ranges.";
							notInRange = true;
						}
						randomString += c;
					}
					else 
						if(s.charAt(i) != 'c' || s.charAt(i) != 'C' || s.charAt(i) != 'd')
						{
							return "Incorrect Input '" + s.charAt(i) + "'";
						}
				if(notInRange)	return "Could not generate String. " + errorMessage;
			}
			return randomString;
		}
	
	/**
	 * getAllCharacters is a private method used by nextString method to retrieve every character in all the Ranges
	 * @return An ArrayList of characters from every Range in ranges.
	 */
	
	private ArrayList<Character> getAllCharacters()
	{
		ArrayList<Character> allChars = new ArrayList<Character>();
		for(int i=0; i < ranges.size(); i++)
		{
			for(int j=0; j < ranges.get(i).getRange().size();j++)
				allChars.add(ranges.get(i).getRange().get(j));
		}
		return allChars;
	}
	
}