package com.apg.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

    private final Music bgMusic;
    private final Sound soundPresentCollect;
    private final Sound soundJump;
    private final Sound soundVictory;
    private final Sound soundGameOver;

    private static SoundManager soundManager = null;

    public SoundManager() {
        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/off_limits.wav"));
        soundPresentCollect = Gdx.audio.newSound((Gdx.files.internal("audio/collect-present.wav")));
        soundJump = Gdx.audio.newSound((Gdx.files.internal("audio/player-jump.wav")));
        soundVictory = Gdx.audio.newSound((Gdx.files.internal("audio/victory.wav")));
        soundGameOver = Gdx.audio.newSound((Gdx.files.internal("audio/game-over.wav")));
    }

    public static SoundManager getInstance() {
        if (soundManager == null) {
            soundManager = new SoundManager();
        }
        return soundManager;
    }

    public Music getBgMusic() {
        return bgMusic;
    }

    public Sound getSoundPresentCollect() {
        return soundPresentCollect;
    }

    public Sound getSoundJump() {
        return soundJump;
    }

    public Sound getSoundVictory() {
        return soundVictory;
    }

    public Sound getSoundGameOver() {
        return soundGameOver;
    }
}
