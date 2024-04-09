package main;

public final class APPLICATION
{
	//FIELDS------------------------------------------
	//custom classes
	@SuppressWarnings("unused")
	private static WINDOW window;
	
	//METHODS-----------------------------------------
	//default
	static void INTIALIZE()
	{
		ASSETS.INITIALIZE();
		window = new WINDOW(FILE_READER.GET_FIRST_LINE_FROM_FILE("res/config/Application_name.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Window_width.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Window_height.txt"));
	}
	
	//public
	public static void RENDER() {WINDOW.RENDER();}
}
