package pojo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GameWindow;
import util.Resource;

public class Clouds {
	private List<ImageCloud> listCloud;
	private BufferedImage cloud;
	private BufferedImage hut;
	private MainCharacter mainCharacter;
	private ImageCloud imageHut; // add a class variable to reference the hut image

	public Clouds(int width, MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		cloud = Resource.getResouceImage("data/cloud.png");
		hut = Resource.getResouceImage("data/hut.png"); // fix the variable name here
		listCloud = new ArrayList<ImageCloud>();

		ImageCloud imageCloud = new ImageCloud();
		imageHut = new ImageCloud(); // initialize the existing class variable
		imageCloud.posX = 0;
		imageCloud.posY = 10;
		listCloud.add(imageCloud);

		imageCloud = new ImageCloud();
		imageCloud.posX = 150;
		imageCloud.posY = 40;
		listCloud.add(imageCloud);

		imageCloud = new ImageCloud();
		imageCloud.posX = 300;
		imageCloud.posY = 50;
		listCloud.add(imageCloud);

		imageCloud = new ImageCloud();
		imageCloud.posX = 450;
		imageCloud.posY = 20;
		listCloud.add(imageCloud);

		imageCloud = new ImageCloud();
		imageCloud.posX = 600;
		imageCloud.posY = 60;
		listCloud.add(imageCloud);

		
		imageHut.posX = 750;
		imageHut.posY = 190;
		listCloud.add(imageHut);
		
		
	}

	public void update(){
		Iterator<ImageCloud> itr = listCloud.iterator();
		ImageCloud firstElement = itr.next();
		firstElement.posX -= mainCharacter.getSpeedX()/8;
		while(itr.hasNext()) {
			ImageCloud element = itr.next();
			element.posX -= mainCharacter.getSpeedX()/8;
		}
		if(firstElement.posX < -cloud.getWidth()) {
			listCloud.remove(firstElement);
			firstElement.posX = GameWindow.SCREEN_WIDTH;
			listCloud.add(firstElement);
		}
	}

	public void draw(Graphics g, double d) {
		for(ImageCloud imgLand : listCloud) {
			if (imgLand == imageHut) {
				g.drawImage(hut, (int) imgLand.posX, imgLand.posY, null);
			}  
			else {
				g.drawImage(cloud, (int) imgLand.posX, imgLand.posY, null);
			}
		}
	}

	private class ImageCloud {
		float posX;
		int posY;
	}
	
	
}