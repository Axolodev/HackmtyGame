package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import tile_map.Background;


public class NotasState extends GameState{
	
	private Background bg;
	
public NotasState(GameStateManager gsm) {
	this.gsm = gsm;
	try {
		bg = new Background("/Backgrounds/FondoN.jpg", 1);
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
	bg.draw(g);// TODO Auto-generated method stub
	
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
