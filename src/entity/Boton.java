package entity;

import java.awt.Graphics2D;

public class Boton extends ScreenObject{
	
	public Boton(){
	}
	
	public void update(){
		x += dx;
		y += dy;
		animation.update();
	}
	
	public void draw(Graphics2D g){
		setMapPosition();
		super.draw(g);
	}
}
