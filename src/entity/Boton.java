package entity;

import java.awt.Graphics2D;

public class Boton extends ScreenObject {
	private int idNumber;

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public Boton() {
	}

	public void update() {
		x += dx;
		y += dy;
		animation.update();
	}

	public void draw(Graphics2D g) {
		setMapPosition();
		super.draw(g);
	}
}
