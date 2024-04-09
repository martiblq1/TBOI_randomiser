package main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.HANDLER;

@SuppressWarnings("serial")
final class WINDOW extends JFrame
{
	//FIELDS------------------------------------------------------------
	//custom classes
	private static final PANEL PANEL = new PANEL();
	
	//METHODS-----------------------------------------------------------
	//constructors
	WINDOW(final String TITLE, final int WIDTH, final int HEIGHT)
	{
		this.setTitle(TITLE);
		this.setLayout(new BorderLayout());
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(PANEL);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	//default
	static void RENDER() {PANEL.repaint();}
	
	//CLASSES
	final static class PANEL extends JPanel
	{
		//FIELDS------------------------------------------
		//custom classes
		private static final MOUSE MOUSE = new MOUSE();
		private static final Drawable[] DRAWABLE_LIST = {HANDLER.GET_BACKGROUND(), HANDLER.GET_R_KEY(), HANDLER.GET_CHARACTER(), HANDLER.GET_BOSS(), HANDLER.GET_PATH()};
		
		//METHODS-----------------------------------------
		//constructors
		PANEL()
		{
			this.setDoubleBuffered(true);
			this.setEnabled(true);
			this.setFocusable(true);
			this.addMouseListener(MOUSE);
			this.setVisible(true);
		}
		
		//implementations
		@Override
		protected void paintComponent(final Graphics GRAPHICS)
		{
			super.paintComponent(GRAPHICS);
			
			for(Drawable drawable : DRAWABLE_LIST)
			{
				if(drawable.check_render()) {drawable.render(GRAPHICS);}
			}
		}
	}
	
	final static class MOUSE implements MouseListener
	{
		//FIELDS-----------------------------------------------------------------------
		//oracle classes
		private static final Clickable[] CLICKABLE_LIST = {HANDLER.GET_R_KEY()};
		
		//METHODS----------------------------------------------------------------------
		//implementations
		@Override
		public void mouseClicked(final MouseEvent EVENT) {}

		@Override
		public void mousePressed(final MouseEvent EVENT) {}

		@Override
		public void mouseReleased(final MouseEvent EVENT)
		{
			for(Clickable clickable : CLICKABLE_LIST)
			{
				if(clickable.check_click(EVENT.getX(), EVENT.getY())) {clickable.click();}
			}
		}

		@Override
		public void mouseEntered(final MouseEvent EVENT) {}

		@Override
		public void mouseExited(final MouseEvent EVENT) {}
	}
}
