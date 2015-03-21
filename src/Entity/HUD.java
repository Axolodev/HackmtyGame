package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.*;

public class HUD {
	private Player player;

	private BufferedImage image;
	private Font font;
    
    /**
     * Metodo para la clase <code> FireBall </code>
     *
     * @param P
     *            es el metodo para mostrar puntos de balas y puntos de vidas
     */
	public HUD(Player p) {
		player = p;
		try {
			image = ImageIO
					.read(getClass().getResourceAsStream("/HUD/hud.gif"));
			font = new Font("Arial", Font.BOLD, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 3, null);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 30, 18);
		g.drawString(player.getFire() / 100 + "/" + player.getMaxFire() / 100,
				30, 38);
	}

}
