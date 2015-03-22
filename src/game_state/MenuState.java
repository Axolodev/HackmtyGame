package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import main.GamePanel;
import tile_map.Background;
import entity.Boton;

public class MenuState extends GameState {

	private Background bg;

	private int currentChoice = 1;
	private String[] options = { "Iniciar", "Ayuda", "Puntuaciones", "Salir" };
	private Boton flechaDerecha, flechaIzquierda;

	private Color titleColor;
	private Font titleFont;

	private Font font;
	private int gameButtonY;

	private boolean movingRight = false;
	private boolean movingLeft = false;
	private Boton[] botonesDeJuego;
	private int NUMEROBOTONES = 3;

	private int movementCounter;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		try {
			bg = new Background("/Backgrounds/FondoC.jpg", 1);
			bg.setVector(0, 0);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 60);
			font = new Font("Arial", Font.PLAIN, 30);

		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
	}

	public void init() {
		botonesDeJuego = new Boton[NUMEROBOTONES];
		gameButtonY = GamePanel.HEIGHT / 2;
		flechaDerecha = new Boton();
		flechaIzquierda = new Boton();

		flechaDerecha.setWidth(140);
		flechaDerecha.setHeight(60);
		flechaIzquierda.setWidth(140);
		flechaIzquierda.setHeight(60);
		flechaDerecha.loadImagesFromStringWithExtension(
				"/Backgrounds/Entidades/Flecha/", 9, ".png");
		flechaIzquierda.loadImagesFromStringWithExtension(
				"/Backgrounds/Entidades/Flecha/", 9, ".png");
		flechaDerecha.setFacingRight(true);
		flechaDerecha.setPosition(GamePanel.WIDTH - 50,
				GamePanel.HEIGHT / 2 - 46);
		flechaIzquierda.setPosition(50, gameButtonY + 20);
		flechaDerecha.setAnimationDelay(70);
		flechaIzquierda.setAnimationDelay(70);

		for (int i = 0; i < NUMEROBOTONES; i++) {
			botonesDeJuego[i].setWidth(200);
			botonesDeJuego[i].setHeight(200);
			botonesDeJuego[i].loadImagesFromStringWithExtension(
					"/Backgrounds/Botones/placeholderImage", 1, ".png");
			botonesDeJuego[i].setPosition(-125 + 525 * i, gameButtonY);
		}

	}

	public void update() {
		bg.update();
		flechaDerecha.update();
		flechaIzquierda.update();
		movementCounter++;
		for (int i = 0; i < NUMEROBOTONES; i++) {
			botonesDeJuego[i].update();
		}
	}

	/**
	 * Metodo para la clase <code> MenuState </code>
	 *
	 * @param g
	 *            dibuja el menu del juego
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
		for(int i = 0 ; i < NUMEROBOTONES ; i++){
			botonesDeJuego[i].setVector(-6, 0);
		}
		flechaDerecha.draw(g);
		flechaIzquierda.draw(g);
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
		if (k == KeyEvent.VK_LEFT) {
			movementCounter = 0;
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
			for(int i = 0 ; i < NUMEROBOTONES ; i++){
				botonesDeJuego[i].setVector(-6, 0);
			}
		}
		if (k == KeyEvent.VK_RIGHT) {
			movementCounter = 0;
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
			for(int i = 0 ; i < NUMEROBOTONES ; i++){
				botonesDeJuego[i].setVector(-6, 0);
			}
		}
		
	
	}

	public void keyReleased(int k) {

	}

}
