package Entity;

import TileMap.TileMap;

public class Enemy extends MapObject {

	public int health;
	protected int maxHealth;
	protected boolean dead;
	protected int damage;

	protected boolean flinching;
	protected long flinchTimer;
	public boolean cayo;
	public Enemy(TileMap tm) {
		super(tm);

	}

	public boolean isDead() {
		return dead;
	}

	public int getDamage() {
		return damage;
	}
    
    /**
     * Metodo para la clase <code> Enemy </code>
     *
     * @param damage
     *            es el metodo para comprobar si se hizo daño en el personajes
     */
	public void hit(int damage) {
		if (dead || flinching)
			return;
		health -= damage;
		if (health < 0)
			health = 0;
		if (health == 0)
			dead = true;
		flinching = true;
		flinchTimer = System.nanoTime();
	}
	
	public void update(){}

}
