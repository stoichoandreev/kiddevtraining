package sniper.kiddevtraining;

import sniper.kiddevtraining.code_render_view.game_interfaces.Image;
import sniper.kiddevtraining.code_render_view.game_interfaces.Music;
import sniper.kiddevtraining.code_render_view.game_interfaces.Sound;

/**
 * Created by sniper on 10/16/16.
 */

public class Assets {
    public static Image menu, splash, background, heroState, heroStateOne, heroStateTwo, heroStateThree, enemyStateOne, enemyStateTwo, enemyStateThree, enemyStateFour, enemyStateFive;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, heroJump, heroDown;
    public static Image button;
    public static Sound click;
    public static Sound shoot;
    public static Sound boom;
    public static Sound dying;
    public static Music theme;

    public static void load(CodeLineListActivity sampleGame) {
        // TODO Auto-generated method stub
        shoot = sampleGame.getAudio().createSound("hero_shoot.wav");
        boom = sampleGame.getAudio().createSound("boom.wav");
//        dying = sampleGame.getMyAudio().createSound("dying.wav");
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(GameSettings.GAME_MUSIC_VOLUME_LEVEL);
    }
}
