package main;

import java.io.FileWriter;
import java.io.IOException;

public final class FILE_WRITER
{
	//METHODS
	//private
	private static void APPEND_LINE(final FileWriter FILE_WRITER, final String LINE)
	{
		try {FILE_WRITER.write(LINE + "\n");}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
	
	private static void WRITE_IN_FILE(final String FILE_PATH, final String DATA)
	{
		try
		{
			final FileWriter WRITER = new FileWriter(FILE_PATH);
			WRITER.write(DATA);
			WRITER.close();
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
	
	//public
	public static void WRITE_IN_FILE_WITH_NEW_LINE(final String FILE_PATH, final String DATA)
	{
		try
		{
			final FileWriter WRITER = new FileWriter(FILE_PATH);
			WRITER.write(DATA + "\n");
			WRITER.close();
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
	
	public static void REMOVE_LINE(final String FILE_PATH, final String TEXT)
	{
		final byte LINE_NUMBER = FILE_READER.FIND_LINE_NUMBER(FILE_PATH, TEXT);
		final String[] LINES = FILE_READER.GET_LINES_FROM_FILE(FILE_PATH);
		
		try
		{
			if(LINES.length <= 1)
			{
				WRITE_IN_FILE_WITH_NEW_LINE(FILE_PATH, "");
				return;
			}
			
			final FileWriter FILE_WRITER = new FileWriter(FILE_PATH, true);
			
			if(LINE_NUMBER == 0)
			{
				WRITE_IN_FILE(FILE_PATH, LINES[1]);
				APPEND_LINE(FILE_WRITER, "");
				for(byte index = 2; index < LINES.length; index++) {APPEND_LINE(FILE_WRITER, LINES[index]);}
				FILE_WRITER.close();
				return;
			}
			
			WRITE_IN_FILE(FILE_PATH, LINES[0]);
			APPEND_LINE(FILE_WRITER, "");
			
			for(byte index = 1; index < LINES.length; index++)
			{
				if(index == LINE_NUMBER) {continue;}
				APPEND_LINE(FILE_WRITER, LINES[index]);
			}
			
			FILE_WRITER.close();
			
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
	
	public static void WRITE_IN_FILE_STRING_ARRAY(final String FILE_PATH, final String[] LINES)
	{
		try
		{
			final FileWriter FILE_WRITER = new FileWriter(FILE_PATH, true);
			WRITE_IN_FILE(FILE_PATH, LINES[0]);
			APPEND_LINE(FILE_WRITER, "");
			for(byte index = 1; index < LINES.length; index++) {APPEND_LINE(FILE_WRITER, LINES[index]);}
			FILE_WRITER.close();
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
}
