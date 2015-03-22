package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import entity.Notas;
import tile_map.Background;


public class NotasState extends GameState{
	
	private Background bg;
	private Notas nota;
	
public NotasState(GameStateManager gsm) {
	this.gsm = gsm;
	nota = new Notas[100]
	try {
		bg = new Background("/Backgrounds/fondojuego1.png", 1);
		for(int i=0; i<100; i++){
			nota[i] = new Notas();	
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

@Override
public void init() {
	// TODO Auto-generated method stub
	
}

@Override
public void update() {
	bg.update();// TODO Auto-generated method stub
	nota.setPosition(nota.getx()-4,nota.gety());

	
}

@Override
public void draw(Graphics2D g) {
	bg.draw(g);
	nota.draw(g);
	g.drawString("K. E. Y.", 150, 200);
}

@Override
public void keyPressed(int k) {
	if (k == KeyEvent.VK_Q) {
		if(nota.getx()<150 && nota.getx()>50){
			nota.setPosition(400,nota.gety());
		}
			
	}
	
	
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(int k) {
	// TODO Auto-generated method stub
	
}
}
