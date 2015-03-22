package entity;

import java.awt.Graphics2D;


public class Notas extends ScreenObject{
	
	public int identificador;
	public Notas(){
		identificador = 1;
		this.setPosition(850,300);
		this.width = 100;
		this.height = 100;
	}
	
	public void draw(Graphics2D g){
		
		this.loadImagesFromStringWithExtension("Triangulo",1,".png");
		
	}

}
