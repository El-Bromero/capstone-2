package com.apg.game.screens;

import com.apg.game.APG;
import com.apg.game.scenes.HUD;
import com.apg.game.sprites.Player;
import com.apg.game.tools.B2WorldCreator;
import com.apg.game.tools.SoundManager;
import com.apg.game.tools.WorldContactListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private APG game;
    private TextureAtlas atlas;

    private OrthographicCamera camera;
    private Viewport gamePort;
    private HUD hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Player player;

    private Music music;

    public GameScreen(APG game) {
        atlas = new TextureAtlas("Player_and_Enemies.pack");

        this.game = game;
        camera = new OrthographicCamera();
        gamePort = new FitViewport(APG.getVWidth() / APG.getPPM(), APG.getVHeight() / APG.getPPM(), camera);
        hud = new HUD(game.getBatch());

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("apg-tile-map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / APG.getPPM());
        camera.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();

        new B2WorldCreator(world, map);

        player = new Player(world, this);

        world.setContactListener(new WorldContactListener());

        music = SoundManager.getInstance().getBgMusic();
        music.setLooping(true);
        music.play();
        music.setVolume(0.1f);

    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            SoundManager.getInstance().getSoundJump().play();
            player.b2Body.applyLinearImpulse(new Vector2(0, 4f), player.b2Body.getWorldCenter(), true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.b2Body.getLinearVelocity().x <= 2) {
            player.b2Body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2Body.getWorldCenter(), true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && player.b2Body.getLinearVelocity().x >= -2) {
            player.b2Body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2Body.getWorldCenter(), true);
        }


    }

    public void update(float dt) {
        handleInput(dt);

        world.step(1/60f, 6, 2);

        player.update(dt);

        camera.position.x = player.b2Body.getPosition().x;

        camera.update();
        renderer.setView(camera);

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, camera.combined);

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        player.draw(game.getBatch());
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(hud.getStage().getCamera().combined);
        hud.getStage().draw();

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.setScreen(new VictoryScreen(game));
            SoundManager.getInstance().getBgMusic().stop();
            SoundManager.getInstance().getSoundVictory().play();
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();
    }
}
