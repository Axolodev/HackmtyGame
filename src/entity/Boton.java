package entity;

import java.awt.Graphics2D;

public class Boton extends ScreenObject{
	
	public Boton(){
	}
	
	public void update(){
		animation.update();
	}
	
	public void draw(Graphics2D g){
		setMapPosition();
		super.draw(g);
		
	}
}
