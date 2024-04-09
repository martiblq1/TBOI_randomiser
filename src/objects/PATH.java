package objects;

import java.awt.Graphics;

import main.ASSETS;
import main.FILE_READER;

final class PATH extends Just_drawable
{
	//FIELDS-------------------------------------------------------------------------------
	//custom classes
	final static PATH OBJECT = new PATH(null, FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Path_x.txt"), FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Path_y.txt"), FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/Path_scale.txt"));
	
	//oracle classes
	private static String[] FLOORS = FILE_READER.GET_LINES_FROM_FILE("res/saves/Path.txt");
	
	//data types
	private static final float Y_OFFSET = FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/Floors_base_y_offset.txt")*FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/Path_scale.txt");
	
	//METHODS------------------------------------------------------------------------------
	//constructors
	PATH(final String IMAGE_NAME, final short X, final short Y, final float SCALE) {super(IMAGE_NAME, X, Y, SCALE);}
	
	//implementations
	@Override
	public boolean check_render() {return true;}

	@Override
	public void render(final Graphics GRAPHICS)
	{
		short y = GET_Y();
		
		for(String floor : FLOORS)
		{
			ASSETS.RENDER(GRAPHICS, floor, GET_X(), y, GET_SCALE());
			y += Y_OFFSET;
		}
	}
	
	//default
	static void UPDATE() {FLOORS = FILE_READER.GET_LINES_FROM_FILE("res/saves/Path.txt");}
}
