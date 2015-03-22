package game_state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tile_map.Background;
import entity.Notas;

public class NotasState extends GameState {

	private Background bg;

	private Notas[] nota;
	private boolean siguiente;
	private int contMax;

	public NotasState(GameStateManager gsm) {
		this.gsm = gsm;
		nota = new Notas[100];
		siguiente = false;
		contMax = 1;
		try {
			bg = new Background("/Backgrounds/fondojuego1.png", 1);
			for (int i = 0; i < 100; i++) {
				nota[i] = new Notas();
			}

		} catch (Exception e) {
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
		for (int j = 0; j < contMax; j++) {

				if (j == 0) {
					nota[j].setPosition(nota[j].getx() - 1, nota[j].gety());
				} else {
					if (nota[j].getx() == nota[j - 1].getx() + 70) {
						nota[j].setPosition(nota[j].getx() - 1, nota[j].gety());
					}
				}
			

		}
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		for (int j = 0; j < contMax; j++) {
			nota[j].draw(g);
		}
		g.drawString("K. E. Y.", 150, 200);
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_Q) {
			for (int j = 0; j < contMax; j++) {
				if (nota[j].getx() < 150 && nota[j].getx() > 50) {
					nota[j].setPosition(850, nota[j].gety());
				}
				if (j == contMax - 1) {
					contMax++;
				}
			}

		}

		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}
}
