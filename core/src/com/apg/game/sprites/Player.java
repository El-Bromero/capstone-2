package com.apg.game.sprites;

import com.apg.game.APG;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends Sprite {
    public World world;
    public Body b2Body;

    public Player(World world) {
        this.world = world;
        definePlayer();
    }

    public void definePlayer() {
        BodyDef bDef = new BodyDef();
        bDef.position.set(32 / APG.getPPM(), 32 / APG.getPPM());
        bDef.type = BodyDef.BodyType.DynamicBody;
        b2Body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / APG.getPPM());

        fDef.shape = shape;
        b2Body.createFixture(fDef);
    }
}
