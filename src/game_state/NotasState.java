package game_state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tile_map.Background;
import entity.Notas;

public class NotasState extends GameState {

	private Background bg;
	private Notas[] nota;
	private int currentNote;
	private int contMax;
	private int noteSeparation;

	public NotasState(GameStateManager gsm) {
		noteSeparation = 150;
		this.gsm = gsm;
		nota = new Notas[100];
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

	}

	@Override
	public void update() {
		for (int j = 0; j < contMax; j++) {
			if (j == 0) {
				nota[j].setVector(-5, 0);
			} else if (nota[j].getx() == nota[j - 1].getx() + 150) {
				nota[j].setVector(-5, 0);
			}
			nota[j].update();
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
			if (nota[currentNote].getx() < 200 && nota[currentNote].getx() > 100) {
				nota[currentNote].setPosition(700 + 150 * contMax, 300);
				currentNote++;
				if (currentNote == contMax) {
					contMax++;
					currentNote = 0;
				}
			}

		}
	}

	@Override
	public void keyReleased(int k) {

	}
}
