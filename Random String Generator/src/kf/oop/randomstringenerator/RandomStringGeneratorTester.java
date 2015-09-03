/**
 * RandomStringGeneratorTester class contains main method for using RandomStringGenerator class.
 * @author Kevin Flaherty
 * 
 */
package kf.oop.randomstringenerator;
import org.apache.commons.cli.*;

public class RandomStringGeneratorTester {
	/**
	 * main method reads command line arguments and generate a random string based on the users input.
	 * 
	 * @param args 'i' is used for inputing the desired length of the string and 's' is used to represent a string that contains
	 * the characters 'c', 'C', and/or 'd'.
	 */
	
	public static void main(String[] args)
	{
		RandomStringGenerator generator = new RandomStringGenerator();
		generator.addRange('0', '9');
		generator.addRange('a', 'z');
		generator.addRange('A', 'Z');
		
		Options options = new Options();
		options.addOption("i", true, "Length of string to generate"); 
		options.addOption("s", true, "Types of chars to generate");
		
		CommandLineParser parser = new BasicParser();
		try	{
			CommandLine line = parser.parse(options, args);
			
			if(line.hasOption("i"))
			{
				try	{
					int length = Integer.parseInt(line.getOptionValue("i"));
					System.out.println(line.getOptionValue("i") + ": " + generator.nextString(length));
				}
				catch(NumberFormatException e)
				{
					System.out.println("Could not read integer. Error: "+ e.getMessage());
				}
			}
			
			if(line.hasOption("s"))
			{
				System.out.println(line.getOptionValue("s") + ": " + generator.nextString(line.getOptionValue("s")));
			}
		}
		
		catch(ParseException ex)
		{
			System.err.println("Parsing failed because of: " + ex.getMessage());
		}	
	}
}
