package sniper.kiddevtraining.code_render_view;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sniper.kiddevtraining.code_render_view.game_interfaces.Audio;
import sniper.kiddevtraining.code_render_view.game_interfaces.Music;
import sniper.kiddevtraining.code_render_view.game_interfaces.Sound;


public class AndroidAudio implements Audio {

    AssetManager assets;
    SoundPool soundPool;
    List<AndroidMusic> musicList;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        musicList = new ArrayList<>();
    }

    @Override
    public Music createMusic(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            final AndroidMusic newMusic = new AndroidMusic(assetDescriptor);
            musicList.add(newMusic);
            return newMusic;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + filename + "'");
        }
    }

    @Override
    public Sound createSound(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }

    @Override
    public void resumeMusic() {
        if (musicList == null) return;
        for(AndroidMusic music : musicList){
            music.play();
        }
    }

    @Override
    public void pauseMusic() {
        if (musicList == null) return;
        for(AndroidMusic music : musicList){
            music.pause();
        }
    }

    @Override
    public void stopMusic() {
        if (musicList == null) return;
        for(AndroidMusic music : musicList){
            music.dispose();
        }
    }
}
