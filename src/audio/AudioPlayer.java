package audio;

import javax.sound.sampled.*;

public class AudioPlayer {

	private Clip clip;

	/**
	 * Constructor default de la clase <code>AudioPlayer</code>
	 * 
	 * @param s
	 *            es el nombre de la pista a escuchar.
	 */
	public AudioPlayer(String s) {

		try {

			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass()
					.getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
					false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(
					decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    /**
     * Metodo para la clase <code> AudioPLayer </code>
     *
     * @param clip
     *            es el metodo que inicia el juego
     */

	public void play() {
		if (clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
    
    /**
     * Metodo para la clase <code> AudioPLayer </code>
     *
     * @param clip
     *            es el metodo que detiene el juego
     */
	public void stop() {
		if (clip.isRunning())
			clip.stop();
	}
    
    /**
     * Metodo para la clase <code> AudioPLayer </code>
     *
     * @param clip
     *            es el metodo que verifica cuando se está jugando
     */
	public boolean isPlaying() {
		return clip.isRunning();
	}

	public void close() {
		stop();
		clip.close();
	}

}