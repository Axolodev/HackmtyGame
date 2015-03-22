package game_state;

public class GameStateManager {

	private GameState[] gameStates;
	private int currentState;
	private int score;
	public static final int NUMGAMESTATES = 2;
	public static final int MENUSTATE = 0;
	public static final int NOTASSTATE = 1;

	public GameStateManager() {
		gameStates = new GameState[NUMGAMESTATES];

		currentState = MENUSTATE;
		loadState(currentState);

	}

	public void increaseScore(int n) {
		score += n;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int n) {
		score = n;
	}

	public void resetScore() {
		score = 0;
	}

	private void loadState(int state) {
		if (state == MENUSTATE) {
			gameStates[state] = new MenuState(this);
		} else if (state == NOTASSTATE) {
			gameStates[state] = new NotasState(this);
		}

	}

	private void unloadState(int state) {
		gameStates[state] = null;
	}

	public void setState(int state) {
		loadState(state);
		currentState = state;
	}

	public void update() {
		try {
			gameStates[currentState].update();
		} catch (Exception e) {
		}
	}

	public void draw(java.awt.Graphics2D g) {
		try {
			gameStates[currentState].draw(g);
		} catch (Exception e) {
		}
	}

	public void keyPressed(int k) {
		if (gameStates[currentState] != null) {
			gameStates[currentState].keyPressed(k);
		}

	}

	public void keyReleased(int k) {
		if (gameStates[currentState] != null) {
			gameStates[currentState].keyReleased(k);
		}
	}

}
