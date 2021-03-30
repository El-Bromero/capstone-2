package com.apg.game.screens;

import com.apg.game.APG;
import com.apg.game.scenes.HUD;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameOverScreen implements Screen {

    private Viewport viewport;
    private Stage stage;

    private Game game;

    private int totalScore;

    public GameOverScreen(Game game) {
        this.game = game;
        viewport = new FitViewport(APG.getVWidth(), APG.getVHeight(), new OrthographicCamera());
        stage = new Stage(viewport, ((APG) game).getBatch());

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label.LabelStyle fontScore = new Label.LabelStyle(new BitmapFont(), Color.YELLOW);
        Label.LabelStyle fontPlay = new Label.LabelStyle(new BitmapFont(), Color.CYAN);
        Label.LabelStyle fontEsc = new Label.LabelStyle(new BitmapFont(), Color.RED);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label gameOverLabel = new Label("GAME OVER!", font);
        table.add(gameOverLabel).expandX();
        table.row();

        totalScore = HUD.getScore();
        Label totalScoreLabel = new Label("Total score: " + String.format("%06d", totalScore), fontScore);
        table.add(totalScoreLabel).expandX().padTop(20f);
        table.row();

        Label playAgainLabel = new Label("Click Anywhere to Try Again", fontPlay);
        table.add(playAgainLabel).expandX().padTop(20f);
        table.row();
        Label escapeLabel = new Label("Hit ESC to Rage Quit", fontEsc);
        table.add(escapeLabel).expandX().padTop(20f);

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
            dispose();
        }
        if(Gdx.input.justTouched()) {
            game.setScreen(new GameScreen((APG) game));
            dispose();
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}