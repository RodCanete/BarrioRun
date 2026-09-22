package pojo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import util.Resource;

public class EnemiesManager {
	
	private BufferedImage chicken;
	private BufferedImage carabao;
	private Random rand;
	
	private List<Obstacles> enemies;
	private MainCharacter mainCharacter;
	private int spawnTimer;
	
	public EnemiesManager() {
    }
	
	public EnemiesManager(MainCharacter mainCharacter) {
		rand = new Random();
		chicken = Resource.getResouceImage("data/chicken.png");
		carabao = Resource.getResouceImage("data/carabao.png");
		
		enemies = new ArrayList<Obstacles>();
		this.mainCharacter = mainCharacter;
		enemies.add(createEnemy());
		spawnTimer = 0;
	}
	
	/**
	 * 
	 */
	public void update() {
	    spawnTimer++;
	    int lowerBound;
		int upperBound;
		
		if (mainCharacter.score >= 1000) {
		    lowerBound = 35;
		    upperBound = 125;
		} else if (mainCharacter.score >= 200) {
		    lowerBound = 50;
		    upperBound = 800;
		} else {
		    lowerBound = 100;
		    upperBound = 1000;
		}
	    
	    int interval = ThreadLocalRandom.current().nextInt(lowerBound, upperBound); // randomize the interval of enemy spawn
	    if (spawnTimer > interval) { 
	        spawnTimer = 0;
	        enemies.add(createEnemy());
	    }
	   
	    for(Enemy e : enemies) {
	        e.update();
	    }
	    
	    if (!enemies.isEmpty()) { // check if the list is not empty
	        Enemy enemy = enemies.get(0); 
	        if(enemy.isOutOfScreen()) {
	            mainCharacter.upScore();
	            enemies.remove(enemy);
	        }
	    }
	}

	/**
	 * 
	 * 
	 * @param g 
	 * @param scale
	 */
	public void draw(Graphics g, double scale) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	/**
	 * 
	 * @return 
	 */
	private Obstacles createEnemy() {
		// if (enemyType = getRandom)
		int type = rand.nextInt(2);
		if(type == 0) {
			return new Obstacles(mainCharacter, 800, chicken.getWidth() - 10, chicken.getHeight() - 10, chicken);
		} else {
			return new Obstacles(mainCharacter, 800, carabao.getWidth() - 10, carabao.getHeight() - 10, carabao);
		}
	}
	

	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (mainCharacter.getBound().intersects(e.getBound())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(createEnemy());
	}
	
}
