package entity;

import java.awt.Graphics2D;

public class Boton extends ScreenObject{
	
	public Boton(){
		this.width = 50;
		this.height = 50;
		this.setPosition(400,200);
		loadImagesFromStringWithExtension("/Backgrounds/Entidades/Triangulo", 1,".png");

	}
	
	public void draw(Graphics2D g){
		setMapPosition();
		super.draw(g);
		
	}
}
