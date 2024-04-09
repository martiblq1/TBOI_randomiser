package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class FILE_READER
{
	//METHODS
	//default
	static byte FIND_LINE_NUMBER(final String FILE_PATH, final String TEXT)
	{
		final String[] LINES = GET_LINES_FROM_FILE(FILE_PATH);
		
		for(byte index = 0; index < LINES.length; index++)
		{
			if(LINES[index].equals(TEXT)) {return index;}
		}
		
		return -1;
	}
	
	//public
	public static String[] GET_LINES_FROM_FILE(final String RELATIVE_FILE_ADDRESS)
	{
		final File FILE = new File(RELATIVE_FILE_ADDRESS);
		
		try
		{
			final Scanner SCANNER_COPY = new Scanner(FILE);
			Scanner scanner = new Scanner(FILE);
			byte number_of_lines = 0;
			
			while(scanner.hasNextLine())
			{
				number_of_lines++;
				scanner.nextLine();
			}
			
			scanner.close();
			scanner = SCANNER_COPY;
			final String[] LINES = new String[number_of_lines];
			for(byte index = 0; index < number_of_lines; index++) {LINES[index] = scanner.nextLine();}
			scanner.close();
			return LINES;
		}
		catch(final FileNotFoundException E) {System.err.println("Could not create a scanner for file.");}
		
		return null;
	}
	
	public static String GET_FIRST_LINE_FROM_FILE(final String RELATIVE_FILE_ADDRESS) {return GET_LINES_FROM_FILE(RELATIVE_FILE_ADDRESS)[0];}

	public static short GET_FIRST_SHORT_FROM_FILE(final String RELATIVE_FILE_ADDRESS)
	{
		final char[] CHARACTERS = GET_FIRST_LINE_FROM_FILE(RELATIVE_FILE_ADDRESS).toCharArray();
		short number = 0;
		final boolean NEGATIVE = CHARACTERS[0] == '-';
		
		if(NEGATIVE)
		{
			for(byte index = 1; index < CHARACTERS.length; index++) {number = (short) (number*10 + CHARACTERS[index] - '0');}
			number *= -1;
			return number;
		}
				
		for(char character : CHARACTERS) {number = (short) (number*10 + character - '0');}
		return number;
	}
	
	public static byte GET_FIRST_BYTE_FROM_FILE(final String RELATIVE_FILE_ADDRESS) {return (byte) GET_FIRST_SHORT_FROM_FILE(RELATIVE_FILE_ADDRESS);}

	public static float GET_FIRST_FLOAT_FROM_FILE(final String RELATIVE_FILE_ADDRESS)
	{
		final char[] CHARACTERS = GET_FIRST_LINE_FROM_FILE(RELATIVE_FILE_ADDRESS).toCharArray();
		float number = 0.0f;
		final boolean NEGATIVE = CHARACTERS[0] == '-';
		boolean point_reached = false;
		
		if(NEGATIVE)
		{
			for(byte index = 1; index < CHARACTERS.length; index++)
			{
				if(CHARACTERS[index] == '.')
				{
					point_reached = true;
					continue;
				}
				
				if(point_reached)
				{
					number = number + ((float)(CHARACTERS[index] - '0')/10);
					continue;
				}
				
				number = number*10 + CHARACTERS[index] - '0';
			}
			
			number *= -1;
			return number;
		}

		for(char character : CHARACTERS)
		{
			if(character == '.')
			{
				point_reached = true;
				continue;
			}
			
			if(point_reached)
			{
				number = number + ((float)(character - '0')/10);
				continue;
			}
			
			number = number*10 + character - '0';
		}
		
		return number;
	}
}
