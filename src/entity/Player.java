package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	private int FPS = main.GamePanel.getFPS();

	public Player(GamePanel gp, KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues();
		getPlayerImage();

	}

	public void setDefaultValues() {

		x = 100;
		y = 100;
		speed = 4;
		direction = "down";

	}

	public void getPlayerImage() {
		try {

			left1a = ImageIO.read(getClass().getResource("/player/redKnight_left_1.png"));
			left1b = ImageIO.read(getClass().getResource("/player/redKnight_left_2.png"));
			left2a = ImageIO.read(getClass().getResource("/player/redKnight_left_3.png"));
			left2b = ImageIO.read(getClass().getResource("/player/redKnight_left_4.png"));
			right1a = ImageIO.read(getClass().getResource("/player/redKnight_right_1.png"));
			right1b = ImageIO.read(getClass().getResource("/player/redKnight_right_2.png"));
			right2a = ImageIO.read(getClass().getResource("/player/redKnight_right_3.png"));
			right2b = ImageIO.read(getClass().getResource("/player/redKnight_righ_4.png"));
			leftIdle = ImageIO.read(getClass().getResource("/player/redKnight_stand_left.png"));
			rightIdle = ImageIO.read(getClass().getResource("/player/redKnight_stand_right.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {

			if (keyH.upPressed == true) {
				y -= speed;

			} else if (keyH.downPressed == true) {
				y += speed;

			} else if (keyH.leftPressed == true) {
				direction = "left";
				x -= speed;

			} else if (keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}

			spriteCounter++;

			if (spriteCounter > (FPS / 6)) {

				if (spriteNum == 1) {
					spriteNum = 2;

				} else if (spriteNum == 2) {
					spriteNum = 3;

				} else if (spriteNum == 3) {
					spriteNum = 4;

				} else if (spriteNum == 4 || spriteNum == 0) {
					spriteNum = 1;

				} 

				spriteCounter = 0;
			}

		} else {
			
			//TODO
			if (spriteNum == 0) {
				spriteNum = 2;
			} else {
				spriteNum = 0;
			}
			
			spriteCounter++;
			
			if (spriteCounter > (FPS / 4)) {
				if (spriteNum == 0) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 0;
				}
				spriteCounter = 0;

			}
		}
	}

	public void draw(Graphics2D g2) {

//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;

		switch (direction) {

		case "left":
			if (spriteNum == 1) {
				image = left1a;
			}
			if (spriteNum == 2) {
				image = left1b;
			}
			if (spriteNum == 3) {
				image = left2a;
			}
			if (spriteNum == 4) {
				image = left2b;
			}
			if (spriteNum == 0) {
				image = leftIdle;
			}

			break;

		case "right":

			if (spriteNum == 1) {
				image = right1a;
			}
			if (spriteNum == 2) {
				image = right1b;
			}
			if (spriteNum == 3) {
				image = right2a;
			}
			if (spriteNum == 4) {
				image = right2b;
			}
			if (spriteNum == 0) {
				image = rightIdle;
			}

			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

	}
}
