package com.apg.game.tools;

import com.apg.game.sprites.InteractiveTileObject;
import com.badlogic.gdx.physics.box2d.*;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if (fixA.getUserData() == "head" || fixB.getUserData() == "head") {
            Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
            Fixture object = head == fixA ? fixB : fixA;

            if(object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())) {
                ((InteractiveTileObject) object.getUserData()).onHeadHit();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {
        // Did not use this method since I do not need to incite code when two fixtures cease to touch
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // Did not use this method since I not to solve anything before making contact between fixtures
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // Did not use this method since I not to solve anything after making contact between fixtures
    }
}
