package com.apg.game.sprites;

import com.apg.game.APG;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Gem extends InteractiveTileObject {

    public Gem(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(APG.getGemBit());
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Gem", "Collision");
        setCategoryFilter(APG.getPickedUpBit());
        getCell().setTile(null);
    }
}
