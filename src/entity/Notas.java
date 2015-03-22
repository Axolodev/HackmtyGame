package entity;

import java.awt.Graphics2D;


public class Notas extends ScreenObject{
	
	
	public int identificador;
	public Notas(){
		identificador = (int) (Math.random()*3);
		if(identificador == 0){
		loadImagesFromStringWithExtension("/Backgrounds/Entidades/triangulo0", 1,".png");
		}
		else if(identificador == 1){
			loadImagesFromStringWithExtension("/Backgrounds/Entidades/circulo0", 1,".png");
		}
		else if(identificador == 2){
			loadImagesFromStringWithExtension("/Backgrounds/Entidades/rombo0", 1,".png");
		}
		this.width = 50;
		this.height = 50;
		this.setPosition(800,200);


	}
	
	public void draw(Graphics2D g){
		setMapPosition();
		super.draw(g);
		
	}

}
