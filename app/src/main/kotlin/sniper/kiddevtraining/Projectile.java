package sniper.kiddevtraining;

import android.graphics.Rect;

/**
 * Created by sniper on 10/16/16.
 */

public class Projectile {
    private int x, y, speedX;
    private boolean visible;

    private Rect r;

    public Projectile(int startX, int startY){
        x = startX;
//        y = 887;  //872
//        TODO da se widi tuk kak moje da se promeni y da se zasi4a w checkcolision da hwashta koga kurshuma e w wraga
        y = startY;
        speedX = GameSettings.HERO_BULLET_SPEED;
        visible = true;

        r = new Rect(0, 0, 0, 0);
    }

    public void update(){
        x += speedX;
        r.set(x, y, x + GameSettings.HERO_BULLET_WIDTH, y + GameSettings.HERO_BULLET_HEIGHT);
        if (x > 800){
            visible = false;
            r = null;
        }
        if (x < 800){
            checkCollision();
        }
    }

    private void checkCollision() {
//        if(Rect.intersects(r, GameScreen.enemyOne.r)){
//            visible = false;
//
//            if (GameScreen.enemyOne.health > 0) {
//                GameScreen.enemyOne.health -= 1;
//            }
//            if (GameScreen.enemyOne.health == 0) {
//                GameScreen.enemyOne.setCenterX(-100);
//                Assets.boom.play(GameSettings.GAME_SOUND_VOLUME_LEVEL);
//            }
//        }
//
//        if (Rect.intersects(r, GameScreen.enemyTwo.r)){
//            visible = false;
//
//            if (GameScreen.enemyTwo.health > 0) {
//                GameScreen.enemyTwo.health -= 1;
//            }
//            if (GameScreen.enemyTwo.health == 0) {
//                GameScreen.enemyTwo.setCenterX(-100);
//                Assets.boom.play(GameSettings.GAME_SOUND_VOLUME_LEVEL);
//            }
//        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

