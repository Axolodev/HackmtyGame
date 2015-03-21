package GameState;

import Audio.AudioPlayer;

public abstract class GameState {

	protected GameStateManager gsm;
	protected static AudioPlayer bgMusic;

	public abstract void init();

	/**
	 * Metodo <code>stopMusic</code> encargado de detener la musica.
	 */
	public void stopMusic() {
		bgMusic.stop();
	}

	/**
	 * Metodo <code>changeMusic</code> encargado de cambiar el estado actual de
	 * la musica
	 */
	public void changeMusic() {
		if (bgMusic.isPlaying())
			bgMusic.stop();
		else
			bgMusic.play();
	}

	/**
	 * Metodo <code> update </code> utilizado para actualizar el
	 * <code> GameState</code> actual.
	 */
	public abstract void update();

	/**
	 * Metodo <code>draw</code> utilizado para dibujar en pantalla los objetos
	 * del <code>GameState</code> actual.
	 * 
	 * @param g es el <code>Graphics2D</code> en el que se dibujara.
	 */
	public abstract void draw(java.awt.Graphics2D g);

	/**
	 * Metodo <code>keyPressed</code> utilizado para manejar las teclas presionadas.
	 * @param k es el valor entero de la tecla presionada
	 */
	public abstract void keyPressed(int k);
	/**
	 * Metodo <code>keyReleased</code> utilizado para manejar las teclas liberadas.
	 * @param k es el valor entero de la tecla liberada
	 */
	public abstract void keyReleased(int k);

}
