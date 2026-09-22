package pojo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Obstacles extends Enemy {
	
	public static final int Y_LAND = 243;
	
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter mainCharacter;
	
	private Rectangle rectBound;
	
	public Obstacles(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) {
		this.posX = posX;
		this.width = width;
		this.height = height;
		this.image = image;
		this.mainCharacter = mainCharacter;
		rectBound = new Rectangle();
	}
	
	public void update() {
		posX -= mainCharacter.getSpeedX();
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void draw(Graphics g) {
		g.drawImage(image, posX, Y_LAND - image.getHeight(), null);
		g.setColor(Color.red);
//		Rectangle bound = getBound();
//		g.drawRect(bound.x, bound.y, bound.width, bound.height);
	}
	
	public Rectangle getBound() {
		Rectangle rectBound = new Rectangle();
	    rectBound.x = (int) posX + (image.getWidth() - width) / 2;
	    rectBound.y = Y_LAND - image.getHeight() + (image.getHeight() - height) / 2;
	    rectBound.width = width;
	    rectBound.height = height;

	    // Perform bounds checks before accessing the raster
	    int xMin = Math.max(0, rectBound.x);
	    int yMin = Math.max(0, rectBound.y);
	    int xMax = Math.min(image.getWidth() - 1, rectBound.x + rectBound.width - 1);
	    int yMax = Math.min(image.getHeight() - 1, rectBound.y + rectBound.height - 1);

	    for (int x = xMin; x <= xMax; x++) {
	        for (int y = yMin; y <= yMax; y++) {
	            int pixel = image.getRGB(x, y);
	            int alpha = (pixel >> 24) & 0xff;
	            if (alpha != 0) {
	                return rectBound;
	            }
	        }
	    }
	    return rectBound;
	}

	@Override
	public boolean isOutOfScreen() {
		if(posX < -image.getWidth()) {
			return true;
		}
		return false;
	}

	
}
