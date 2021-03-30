package com.apg.game.sprites;

import com.apg.game.APG;
import com.apg.game.screens.GameScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite {
    public enum State { FALLING, JUMPING, STANDING, RUNNING};
    public State currentState;
    public State previousState;
    public World world;
    public Body b2Body;
    private TextureRegion playerStand;
    private Animation<TextureRegion> playerRun;
    private Animation<TextureRegion> playerJump;
    private float stateTimer;
    private boolean runningRight;

    public Player(World world, GameScreen screen) {
        super(screen.getAtlas().findRegion("player"));
        this.world = world;
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<>();
        // Until num of frames for animation
        for (int i = 1; i < 4; i++) {
            frames.add(new TextureRegion(getTexture(), i * 16 + 1, 0, 16, 16));
        }
        playerRun = new Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        //
        for (int i = 4; i < 6; i++) {
            frames.add(new TextureRegion(getTexture(), i * 16 + 1, 0, 16, 16));
        }
        playerJump = new Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        playerStand = new TextureRegion(getTexture(), 1, 0, 16, 16);

        definePlayer();
        setBounds(0, 0, 16 / APG.getPPM(), 16 / APG.getPPM());
        setRegion(playerStand);
    }

    public void update(float dt) {
        setPosition((b2Body.getPosition().x - getWidth() / 2), (b2Body.getPosition().y - getHeight() / 2));
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        currentState = getState();

        TextureRegion region;
        switch (currentState) {
            // Overriding here
            case JUMPING:
                region = playerJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = playerRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = playerStand;
                break;
        }

        // Checks if player sprite is moving left or right
        if ((b2Body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        }
        else if ((b2Body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;
        return region;
    }

    public State getState() {
        // Check if he is actually falling from jump and not from ledge // old: || (b2Body.getLinearVelocity().y < 0 && previousState == State.FALLING)
        if (b2Body.getLinearVelocity().y > 0) {
            return State.JUMPING;
        }
        else if (b2Body.getLinearVelocity().y < 0) {
            return State.FALLING;
        }
        else if (b2Body.getLinearVelocity().x != 0) {
            return State.RUNNING;
        }
        else {
            return State.STANDING;
        }
    }

    public void definePlayer() {
        BodyDef bDef = new BodyDef();
        bDef.position.set(32 / APG.getPPM(), 32 / APG.getPPM());
        bDef.type = BodyDef.BodyType.DynamicBody;
        b2Body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / APG.getPPM()); // radius

        fDef.filter.categoryBits = APG.getPlayerBit();
        fDef.filter.maskBits = (short) (APG.getDefaultBit() | APG.getPresentBit());

        fDef.shape = shape;
        b2Body.createFixture(fDef);

        // This cancels upward velocity when leaving edge of block
        FixtureDef fDef2 = new FixtureDef();
        EdgeShape feet = new EdgeShape();
        feet.set(new Vector2(-2 / APG.getPPM(), -6 / APG.getPPM()), new Vector2(2 / APG.getPPM(), -6 / APG.getPPM()));
        fDef2.shape = feet;
        b2Body.createFixture(fDef2);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2 / APG.getPPM(), 8 / APG.getPPM()), new Vector2(-2 / APG.getPPM(), 8 / APG.getPPM()));
        fDef.shape = head;
        fDef.isSensor = true;

        b2Body.createFixture(fDef).setUserData("head");
    }
}
