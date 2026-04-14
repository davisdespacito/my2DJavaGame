package entity;

import java.awt.image.BufferedImage;

public class Entity {

	public int x, y;
	public int speed;
	
	// REMEMBER TO ADD SPRITE IMAGES TO res/player PACKAGE
	public BufferedImage left1a, left1b, left2a, left2b, 
		right1a, right1b, right2a, right2b, leftIdle, rightIdle;
	
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 0;

}
