package main;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public final class ASSETS
{
	//FIELDS
	//data types
	private static final short RESOLUTION_WIDTH = (short)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1920), RESOLUTION_HEIGHT = (short)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1080);
	
	//oracle classes
	private static final HashMap<String, BufferedImage> IMAGES = new HashMap<String, BufferedImage>();
	
	//METHODS
	//default
	static void INITIALIZE()
	{
		final String[] IDS = FILE_READER.GET_LINES_FROM_FILE("res/config/Images_ids.txt"), IMAGES_PATHS = FILE_READER.GET_LINES_FROM_FILE("res/config/Images_paths.txt");
		
		try
		{
			for(byte index = 0; index < IDS.length; index++) {IMAGES.put(IDS[index], ImageIO.read(new File(IMAGES_PATHS[index])));}
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
		
		final String[] CHARACTER_IDS = FILE_READER.GET_LINES_FROM_FILE("res/config/Character_images_ids.txt"), BOSSES_IDS = FILE_READER.GET_LINES_FROM_FILE("res/config/End_bosses_ids.txt"), FLOORS_IDS = FILE_READER.GET_LINES_FROM_FILE("res/config/Floors_ids.txt");
		
		try
		{
			final BufferedImage CHARACTER_SPRITES = ImageIO.read(new File("res/images/Characters_images_sheet.png")), END_BOSSES_SPRITES = ImageIO.read(new File("res/images/End_bosses_sheet.png")), FLOORS_SPRITES = ImageIO.read(new File("res/images/Floors.png"));
			final byte CHARACTERS_IMAGES_SPRITESHEET_STARTING_X = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Character_images_spritesheet_statrting_x.txt"), CHARACTERS_IMAGES_SPRITESHEET_STARTING_Y = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Character_images_spritesheet_statrting_y.txt"), CHARACTERS_IMAGES_SPRITESHEET_IMAGE_WIDTH = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Character_images_spritesheet_image_width.txt"), CHARACTERS_IMAGES_SPRITESHEET_IMAGE_HEIGHT = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Character_images_spritesheet_image_height.txt"), BOSS_IMAGES_SPRITESHEET_STARTING_X = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Boss_images_spritesheet_starting_x.txt"), BOSS_IMAGES_SPRITESHEET_STARTING_Y = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Boss_images_spritesheet_starting_y.txt"), BOSS_IMAGES_SPRITESHEET_IMAGE_WIDTH = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Boss_images_spritesheet_image_width.txt"), BOSS_IMAGES_SPRITESHEET_IMAGE_HEIGHT = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Boss_images_spritesheet_image_height.txt"), FLOORS_SPRITESHEET_STARTING_X = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Floors_spritesheet_starting_x.txt"), FLOORS_SPRITESHEET_STARTING_Y = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Floors_spritesheet_statrting_y.txt"), FLOORS_SPRITESHEET_WIDTH = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Floors_spritesheet_width.txt"), FLOORS_SPRITESHEET_HEIGHT = FILE_READER.GET_FIRST_BYTE_FROM_FILE("res/config/Floors_spritesheet_height.txt");
			for(byte index = 0; index < CHARACTER_IDS.length; index++) {IMAGES.put(CHARACTER_IDS[index], CHARACTER_SPRITES.getSubimage(CHARACTERS_IMAGES_SPRITESHEET_STARTING_X, CHARACTERS_IMAGES_SPRITESHEET_STARTING_Y + index*CHARACTERS_IMAGES_SPRITESHEET_IMAGE_HEIGHT, CHARACTERS_IMAGES_SPRITESHEET_IMAGE_WIDTH, CHARACTERS_IMAGES_SPRITESHEET_IMAGE_HEIGHT));}
			for(byte index = 0; index < BOSSES_IDS.length; index++) {IMAGES.put(BOSSES_IDS[index], END_BOSSES_SPRITES.getSubimage(BOSS_IMAGES_SPRITESHEET_STARTING_X, BOSS_IMAGES_SPRITESHEET_STARTING_Y + index*BOSS_IMAGES_SPRITESHEET_IMAGE_HEIGHT, BOSS_IMAGES_SPRITESHEET_IMAGE_WIDTH, BOSS_IMAGES_SPRITESHEET_IMAGE_HEIGHT));}
			for(byte index = 0; index < FLOORS_IDS.length; index++) {IMAGES.put(FLOORS_IDS[index], FLOORS_SPRITES.getSubimage(FLOORS_SPRITESHEET_STARTING_X, FLOORS_SPRITESHEET_STARTING_Y + index*FLOORS_SPRITESHEET_HEIGHT, FLOORS_SPRITESHEET_WIDTH, FLOORS_SPRITESHEET_HEIGHT));}
		}
		catch (final IOException EXCEPTION) {EXCEPTION.printStackTrace();}
	}
	
	//public
	public static void RENDER(final Graphics GRAPHICS, final String IMAGE_NAME, final short X, final short Y, final float SCALE)
	{
		final BufferedImage IMAGE = IMAGES.get(IMAGE_NAME);
		GRAPHICS.drawImage(IMAGE, X*RESOLUTION_WIDTH, Y*RESOLUTION_HEIGHT, (int)(IMAGE.getWidth()*SCALE*RESOLUTION_WIDTH), (int)(IMAGE.getHeight()*SCALE*RESOLUTION_HEIGHT), null);
	}
}
