package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public class Event extends MapObject {

	private BufferedImage[] sprite;

	public Event(TileMap tm, int x, int y) {
		super(tm);
		this.x = x; 
		this.y = y;
		moveSpeed = 0;
		width = 32;
		height = 40;
		cwidth = 26;
		cheight = 35;

		sprite = new BufferedImage[1];
		
		// cargar sprites
		try {
			
			sprite[0] = ImageIO.read(getClass().getResourceAsStream(
					"/Sprites/Player/Door.png"));
			animation = new Animation();
			animation.setFrames(sprite);
			animation.setDelay(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void draw(Graphics2D g) {

		setMapPosition();

		super.draw(g);

	}

}
