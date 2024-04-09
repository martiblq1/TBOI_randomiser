package objects;

import main.FILE_READER;

final class BACKGROUND extends Just_drawable
{
	//FIELDS----------------------------------------------------------------
	//custom classes
	final static BACKGROUND OBJECT = new BACKGROUND("background", FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Background_x.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Background_y.txt"), FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/Background_scale.txt"));
	
	//METHODS---------------------------------------------------------------
	//constructors
	private BACKGROUND(final String IMAGE_NAME, final short X, final short Y, final float SCALE) {super(IMAGE_NAME, X, Y, SCALE);}

	//implementations
	@Override
	public boolean check_render() {return true;}
}
