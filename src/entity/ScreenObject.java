package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ScreenObject {

	// position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;

	// dimensions
	protected int width;
	protected int height;

	// collision box
	protected int cwidth;
	protected int cheight;

	// collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;

	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;

	// movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;

	// movement attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;

	public ScreenObject() {
	}

	public void loadImagesFromStringWithExtension(String st, int amountImages,
			String extension) {
		BufferedImage bi[] = new BufferedImage[amountImages];

		try {
			for (int i = 0; i < amountImages; i++) {
				bi[i] = ImageIO.read(getClass()
						.getResourceAsStream(st + i + extension));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		animation = new Animation();
		animation.setFrames(bi);
	}

	public boolean intersects(ScreenObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}

	public Rectangle getRectangle() {
		return new Rectangle((int) x - cwidth, (int) y - cheight, cwidth,
				cheight);
	}

	public void calculateCorners(double x, double y) {

	}

	public int getx() {
		return (int) x;
	}

	public int gety() {
		return (int) y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getCWidth() {
		return cwidth;
	}

	public int getCHeight() {
		return cheight;
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void setMapPosition() {

	}

	public void setLeft(boolean b) {
		left = b;
	}

	public void setRight(boolean b) {
		right = b;
	}

	public void setUp(boolean b) {
		up = b;
	}

	public void setDown(boolean b) {
		down = b;
	}

	public boolean notOnScreen() {
		return x + width < 0 || x - width > GamePanel.WIDTH || y + height < 0
				|| y + height > GamePanel.HEIGHT;
	}

	public void draw(java.awt.Graphics2D g) {
		if (facingRight) {
			g.drawImage(animation.getImage(), (int) (x - width / 2),
					(int) (y + height / 2), null);
		} else {
			g.drawImage(animation.getImage(), (int) (x - width / 2 + width),
					(int) (y - height / 2), -width, height, null);
		}
	}
}

