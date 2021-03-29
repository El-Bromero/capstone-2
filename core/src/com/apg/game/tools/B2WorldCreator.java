package com.apg.game.tools;

import com.apg.game.APG;
import com.apg.game.sprites.Present;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class B2WorldCreator {

    public B2WorldCreator (World world, TiledMap map) {
        BodyDef bDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fDef = new FixtureDef();
        Body body;

        // get from 2 since ground object is 3rd from bottom of tmx layer
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bDef.type = BodyDef.BodyType.StaticBody;
            bDef.position.set((rect.getX() + rect.getWidth() / 2) / APG.getPPM(), (rect.getY() + rect.getHeight() / 2) / APG.getPPM());

            body = world.createBody(bDef);

            shape.setAsBox(rect.getWidth() / 2 / APG.getPPM(), rect.getHeight() / 2 / APG.getPPM());
            fDef.shape = shape;
            body.createFixture(fDef);
        }

        // Create present (4) bodies/fixtures
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Present(world, map, rect);
        }
    }
}
