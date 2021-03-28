package com.apg.game.sprites;

import com.apg.game.APG;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class InteractiveTileObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;

    public InteractiveTileObject(World world, TiledMap map, Rectangle bounds) {
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        BodyDef bDef = new BodyDef();
        FixtureDef fDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bDef.type = BodyDef.BodyType.StaticBody;
        bDef.position.set((bounds.getX() + bounds.getWidth() / 2) / APG.getPPM(), (bounds.getY() + bounds.getHeight() / 2) / APG.getPPM());

        body = world.createBody(bDef);

        shape.setAsBox(bounds.getWidth() / 2 / APG.getPPM(), bounds.getHeight() / 2 / APG.getPPM());
        fDef.shape = shape;
        body.createFixture(fDef);
    }
}
