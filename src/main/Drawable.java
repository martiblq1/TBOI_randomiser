package main;

import java.awt.Graphics;

public interface Drawable
{
	//METHODS
	//default
	boolean check_render();
	void render(final Graphics GRAPHICS);
}
