package objects;

import java.awt.Graphics;

import main.ASSETS;
import main.Drawable;

abstract class Just_drawable implements Drawable
{
	//FIELDS--------------------------------------------
	//oracle classes
	private final String IMAGE_NAME;
	//data types
	private final short X, Y;
	private final float SCALE;
	
	//METHODS-------------------------------------------
	//constructors
	Just_drawable(final String IMAGE_NAME, final short X, final short Y, final float SCALE)
	{
		this.IMAGE_NAME = IMAGE_NAME;
		this.X = X;
		this.Y = Y;
		this.SCALE = SCALE;
	}
	
	//implementations
	@Override
	public abstract boolean check_render();

	@Override
	public void render(Graphics GRAPHICS) {ASSETS.RENDER(GRAPHICS, IMAGE_NAME, X, Y, SCALE);}
	
	//getters
	protected final short GET_X() {return X;}
	protected final short GET_Y() {return Y;}
	protected final float GET_SCALE() {return SCALE;}
}
