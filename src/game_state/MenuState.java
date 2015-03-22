package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import tile_map.Background;

public class MenuState extends GameState {

	private Background bg;

	private int currentChoice = 0;
	private String[] options = { "Iniciar", "Ayuda", "Puntuaciones", "Salir" };

	private Color titleColor;
	private Font titleFont;

	private Font font; 
 
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		try {
			bg = new Background("/Backgrounds/Fondo.jpg", 1);
			bg.setVector(0, 0);
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 60);
			font = new Font("Arial", Font.PLAIN, 30);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {
	}

	public void update() {
		bg.update();
	}

    /**
     * Metodo para la clase <code> MenuState </code>
     *
     * @param g
     *              dibuja el menu del juego
     */
	public void draw(Graphics2D g) {

		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("K. E. Y.", 115, 70);

		// draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.white);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 40);
		}

	}

	private void select() {
		if (currentChoice == options.length - 1) {
			System.exit(0);
		}
	}

    /**
     * Metodo para la clase <code> MenuState </code>
     *
     * @param k
     *            es la tecla que realiza las opciones
     */
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}

	public void keyReleased(int k) {
		
	}

}
