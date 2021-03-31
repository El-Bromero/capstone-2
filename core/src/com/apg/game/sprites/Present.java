package com.apg.game.sprites;

import com.apg.game.APG;
import com.apg.game.scenes.HUD;
import com.apg.game.tools.SoundManager;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Present extends InteractiveTileObject {

    public Present(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(APG.getPresentBit());
    }

    @Override
    public void onHeadHit() {
        setCategoryFilter(APG.getPickedUpBit());
        getCell().setTile(null);
        SoundManager.getInstance().getSoundPresentCollect().play();
        HUD.addScore(200);
    }
}
