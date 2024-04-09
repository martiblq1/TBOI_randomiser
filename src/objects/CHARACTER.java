package objects;

import java.awt.Graphics;

import main.ASSETS;
import main.FILE_READER;

final class CHARACTER extends Just_drawable
{
	//FIELDS-------------------------------------------------------------
	//custom classes
	static final CHARACTER OBJECT = new CHARACTER(null, FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Character_x.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Character_y.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Character_scale.txt"));
	
	//oracle classes
	private static String character_id = FILE_READER.GET_FIRST_LINE_FROM_FILE("res/saves/Current_character.txt");
	
	//METHODS------------------------------------------------------------
	//constructors
	private CHARACTER(final String IMAGE_NAME, final short X, final short Y, final float SCALE) {super(IMAGE_NAME, X, Y, SCALE);}

	//implementations
	@Override
	public boolean check_render() {return true;}
	
	@Override
	public void render(final Graphics GRAPHICS) {ASSETS.RENDER(GRAPHICS, character_id, GET_X(), GET_Y(), GET_SCALE());}

	//default
	final static void UPDATE() {character_id = FILE_READER.GET_FIRST_LINE_FROM_FILE("res/saves/Current_character.txt");}
}
