package objects;

import java.awt.Rectangle;

import main.Clickable;

abstract class Drawable_and_clickable extends Just_drawable implements Clickable
{
	//FIELDS------------------------------------------------------------------------------------------------------
	//oracle classes
	private final Rectangle BOUNDS;
	
	//METHODS-----------------------------------------------------------------------------------------------------
	//constructors
	Drawable_and_clickable(final String IMAGE_NAME, final short X, final short Y, final float SCALE, final short X_BOUNDS, final short Y_BOUNDS, final float WIDTH, final float HEIGHT)
	{
		super(IMAGE_NAME, X, Y, SCALE);
		BOUNDS = new Rectangle(X_BOUNDS, Y_BOUNDS, (short)(WIDTH), (short)(HEIGHT));
	}

	//implementations
	@Override
	public abstract boolean check_render();

	@Override
	public boolean check_click(final int X, final int Y) {return BOUNDS.contains(X, Y);}

	@Override
	public abstract void click();
}
