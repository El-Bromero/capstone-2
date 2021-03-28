package com.apg.game;

import com.apg.game.screens.GameScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class APG extends Game {

	private static final int V_WIDTH = 400;
	private static final int V_HEIGHT = 208;
	private static final float PPM = 100; // Pixels per meter

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

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
