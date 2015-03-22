package entity;

import java.awt.Graphics2D;


public class Notas extends ScreenObject{
	
	
	public int identificador;
	public Notas(){
		identificador = 1;
		this.width = 100;
		this.height = 100;
		this.setPosition(200,200);
		loadImagesFromStringWithExtension("/Backgrounds/Entidades/Triangulo", 1,".png");

	}
	
	public void draw(Graphics2D g){
		setMapPosition();
		super.draw(g);
		
	}

}
