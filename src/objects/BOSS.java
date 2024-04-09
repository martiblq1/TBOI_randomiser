package objects;

import java.awt.Graphics;

import main.ASSETS;
import main.FILE_READER;

final class BOSS extends Just_drawable
{
	//FIELDS-----------------------------------------------------------
	//custom classes
	static final BOSS OBJECT = new BOSS(null, FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Boss_x.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/Boss_y.txt"), FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/Boss_scale.txt"));
	
	//oracle classes
	private static String boss_id = FILE_READER.GET_FIRST_LINE_FROM_FILE("res/saves/Current_boss.txt");
	
	//METHODS----------------------------------------------------------
	//constructors
	private BOSS(final String IMAGE_NAME, final short X, final short Y, final float SCALE) {super(IMAGE_NAME, X, Y, SCALE);}

	//implementations
	@Override
	public boolean check_render() {return true;}
	
	@Override
	public void render(final Graphics GRAPHICS) {ASSETS.RENDER(GRAPHICS, boss_id, GET_X(), GET_Y(), GET_SCALE());}
	
	//default
	final static void UPDATE() {boss_id = FILE_READER.GET_FIRST_LINE_FROM_FILE("res/saves/Current_boss.txt");}
}
