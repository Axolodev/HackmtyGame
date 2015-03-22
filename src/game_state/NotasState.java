package game_state;

import java.awt.*;


import entity.Notas;
import tile_map.Background;


public class NotasState extends GameState{
	
	private Background bg;
	private Notas nota;
	
public NotasState(GameStateManager gsm) {
	this.gsm = gsm;
	try {
		bg = new Background("/Backgrounds/fondojuego1.png", 1);
		nota = new Notas();
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
	
}

@Override
public void draw(Graphics2D g) {
	bg.draw(g);
	nota.draw(g);
	
}

@Override
public void keyPressed(int k) {
	
	
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(int k) {
	// TODO Auto-generated method stub
	
}
}
