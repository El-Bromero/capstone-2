package com.apg.game;

import com.apg.game.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class APG extends Game {

	private static final int V_WIDTH = 400;
	private static final int V_HEIGHT = 208;
	private static final float PPM = 100; // Pixels per meter

	private static final short DEFAULT_BIT = 1;
	private static final short PLAYER_BIT = 2;
	private static final short PRESENT_BIT = 8;
	private static final short PICKED_UP_BIT = 16;
	private static final short GEM_BIT = 32;

	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	public static int getVWidth() {
		return V_WIDTH;
	}

	public static int getVHeight() {
		return V_HEIGHT;
	}

	public static float getPPM() {
		return PPM;
	}

	public static short getDefaultBit() {
		return DEFAULT_BIT;
	}

	public static short getPlayerBit() {
		return PLAYER_BIT;
	}

	public static short getPresentBit() {
		return PRESENT_BIT;
	}

	public static short getPickedUpBit() {
		return PICKED_UP_BIT;
	}

	public static short getGemBit() {
		return GEM_BIT;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
	}
}
