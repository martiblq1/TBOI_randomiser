package objects;

import java.util.Random;

import main.APPLICATION;
import main.FILE_READER;
import main.FILE_WRITER;

final class R_KEY extends Drawable_and_clickable
{
	//FIELDS------------------------------------------------------------------------------------
	//oracle classes
	private static final Random RANDOM = new Random();
	private String[] CHARACTERS, BOSSES, FLOORS;
	private String CURRENT_CHARACTER, CURRENT_BOSS;
	
	//custom classes
	final static R_KEY OBJECT = new R_KEY("r_key", FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_x.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_y.txt"), FILE_READER.GET_FIRST_FLOAT_FROM_FILE("res/config/R_key_scale.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_x.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_y.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_width.txt"), FILE_READER.GET_FIRST_SHORT_FROM_FILE("res/config/R_key_height.txt"));
	
	//data types
	static int pocket;
	
	//METHODS-----------------------------------------------------------------------------------
	//constructors
	private R_KEY(final String IMAGE_NAME, final short X, final short Y, final float SCALE, final short X_BOUNDS, final short Y_BOUNDS, final short WIDTH, final short HEIGHT) {super(IMAGE_NAME, X, Y, SCALE, X_BOUNDS, Y_BOUNDS, WIDTH*SCALE, HEIGHT*SCALE);}

	//implementations
	@Override
	public boolean check_render() {return true;}

	@Override
	public void click()
	{
		CHARACTERS = FILE_READER.GET_LINES_FROM_FILE("res/saves/Undone_characters.txt");
		BOSSES = FILE_READER.GET_LINES_FROM_FILE("res/saves/Undone_bosses.txt");
		CURRENT_CHARACTER = CHARACTERS[RANDOM.nextInt(CHARACTERS.length)];
		CURRENT_BOSS = BOSSES[RANDOM.nextInt(BOSSES.length)];
		FILE_WRITER.WRITE_IN_FILE_WITH_NEW_LINE("res/saves/Current_character.txt", CURRENT_CHARACTER);
		FILE_WRITER.WRITE_IN_FILE_WITH_NEW_LINE("res/saves/Current_boss.txt", CURRENT_BOSS);
		FILE_WRITER.REMOVE_LINE("res/saves/Undone_characters.txt", CURRENT_CHARACTER);
		FILE_WRITER.REMOVE_LINE("res/saves/Undone_bosses.txt", CURRENT_BOSS);
		CHARACTER.UPDATE();
		BOSS.UPDATE();
		if(CHARACTERS.length == 1) {FILE_WRITER.WRITE_IN_FILE_STRING_ARRAY("res/saves/Undone_characters.txt", FILE_READER.GET_LINES_FROM_FILE("res/config/Character_images_ids.txt"));}
		if(BOSSES.length == 1) {FILE_WRITER.WRITE_IN_FILE_STRING_ARRAY("res/saves/Undone_bosses.txt", FILE_READER.GET_LINES_FROM_FILE("res/config/End_bosses_ids.txt"));}

		switch(CURRENT_BOSS)
		{
		case "mom", "boss_rush":
			FLOORS = new String[6];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							FLOORS[5] = "depths";//depths II
							break;
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							FLOORS[5] = "depths";//depths II
							break;
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "depths";//depths II
						break;
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							FLOORS[5] = "depths";//depths II
							break;
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							FLOORS[5] = "depths";//depths II
							break;
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "depths";//depths II
						break;
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						FLOORS[5] = "depths";//depths II
						break;
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "depths";//depths II
						break;
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "depths";//depths II
					break;
				}
			}
			
		case "mom_b", "boss_rush_b":
			FLOORS = new String[7];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							break;
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							break;
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						break;
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							break;
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							break;
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						break;
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						break;
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						break;
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					break;
				}
			}
			
		case "moms_heart":
			FLOORS = new String[7];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					break;
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					break;
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					break;
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					break;
				}
			}
			
		case "it_lives":
			FLOORS = new String[8];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						break;
					}
				}
			}
			
		case "mother":
			FLOORS = new String[9];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					FLOORS[7] = "corpse";//corpse I
					FLOORS[8] = "corpse";//corpse II
					break;
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					FLOORS[7] = "corpse";//corpse I
					FLOORS[8] = "corpse";//corpse II
					break;
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					FLOORS[7] = "corpse";//corpse I
					FLOORS[8] = "corpse";//corpse II
					break;
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					FLOORS[5] = "mausoleum";//mausoleum I
					FLOORS[6] = "mausoleum";//mausoleum II
					FLOORS[7] = "corpse";//corpse I
					FLOORS[8] = "corpse";//corpse II
					break;
				}
			}
			
		case "isaac_boss":
			FLOORS = new String[9];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "cathedral";//cathedral
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "cathedral";//cathedral
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "cathedral";//cathedral
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "cathedral";//cathedral
						break;
					}
				}
			}
			
		case "satan":
			FLOORS = new String[9];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "sheol";//sheol
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "sheol";//sheol
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "sheol";//sheol
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "sheol";//sheol
						break;
					}
				}
			}
			
		case "hush":
			FLOORS = new String[9];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						break;
					}
				}
			}
			
		case "delirium":
			FLOORS = new String[10];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "void";//void
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "void";//void
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "void";//void
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "void";//void
						break;
					}
				}
			}
			
		case "???_boss":
			FLOORS = new String[11];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "cathedral";//cathedral
								FLOORS[10] = "chest";//chest
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "cathedral";//cathedral
							FLOORS[10] = "chest";//chest
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "cathedral";//cathedral
						FLOORS[10] = "chest";//chest
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "cathedral";//cathedral
						FLOORS[10] = "chest";//chest
						break;
					}
				}
			}
			
		case "lamb":
			FLOORS = new String[11];
			FLOORS[0] = "basement";//basement I
			pocket = RANDOM.nextInt(2);
			
			if(pocket == 0)
			{
				FLOORS[1] = "basement";//basement II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[2] = "caves";//caves I
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
					}
				}
				else
				{
					FLOORS[2] = "downpour";//downpour II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[3] = "caves";//caves II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[4] = "depths";//depths I
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
						}
						else
						{
							FLOORS[4] = "mines";//mines II
							pocket = RANDOM.nextInt(2);
							
							if(pocket == 0)
							{
								FLOORS[5] = "depths";//depths II
								FLOORS[6] = "womb";//womb I
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
							else
							{
								FLOORS[5] = "mausoleum";//mausoleum I
								FLOORS[6] = "mausoleum";//mausoleum II
								FLOORS[7] = "womb";//womb II
								FLOORS[8] = "???_floor";//???
								FLOORS[9] = "sheol";//sheol
								FLOORS[10] = "dark_room";//dark_room
								break;
							}
						}
					}
					else
					{
						FLOORS[3] = "mines";//mines I
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
					}
				}
			}
			else
			{
				FLOORS[1] = "downpour";//downpour I
				FLOORS[2] = "downpour";//downpour II
				pocket = RANDOM.nextInt(2);
				
				if(pocket == 0)
				{
					FLOORS[3] = "caves";//caves II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[4] = "depths";//depths I
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
					}
					else
					{
						FLOORS[4] = "mines";//mines II
						pocket = RANDOM.nextInt(2);
						
						if(pocket == 0)
						{
							FLOORS[5] = "depths";//depths II
							FLOORS[6] = "womb";//womb I
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
						else
						{
							FLOORS[5] = "mausoleum";//mausoleum I
							FLOORS[6] = "mausoleum";//mausoleum II
							FLOORS[7] = "womb";//womb II
							FLOORS[8] = "???_floor";//???
							FLOORS[9] = "sheol";//sheol
							FLOORS[10] = "dark_room";//dark_room
							break;
						}
					}
				}
				else
				{
					FLOORS[3] = "mines";//mines I
					FLOORS[4] = "mines";//mines II
					pocket = RANDOM.nextInt(2);
					
					if(pocket == 0)
					{
						FLOORS[5] = "depths";//depths II
						FLOORS[6] = "womb";//womb I
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "sheol";//sheol
						FLOORS[10] = "dark_room";//dark_room
						break;
					}
					else
					{
						FLOORS[5] = "mausoleum";//mausoleum I
						FLOORS[6] = "mausoleum";//mausoleum II
						FLOORS[7] = "womb";//womb II
						FLOORS[8] = "???_floor";//???
						FLOORS[9] = "sheol";//sheol
						FLOORS[10] = "dark_room";//dark_room
						break;
					}
				}
			}
		}
		
		if(FLOORS != null) {FILE_WRITER.WRITE_IN_FILE_STRING_ARRAY("res/saves/Path.txt", FLOORS);}
		PATH.UPDATE();
		APPLICATION.RENDER();
	}
}
