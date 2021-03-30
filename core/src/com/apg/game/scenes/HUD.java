package com.apg.game.scenes;

import com.apg.game.APG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HUD implements Disposable {
    private Stage stage;
    private Viewport viewport;

    private static Integer score;

    private static Label scoreLabel;
    private Label personLabel;

    public HUD(SpriteBatch sb) {
        score = 0;
        viewport = new FitViewport(APG.getVWidth(), APG.getVHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        personLabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(personLabel).expandX().padTop(0);
        table.row();
        table.add(scoreLabel).expandX();

        stage.addActor(table);
    }

    public Stage getStage() {
        return stage;
    }

    public static void addScore(int value) {
        score += value;
        scoreLabel.setText(String.format("%06d", score));
    }

    public static Integer getScore() {
        return score;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
