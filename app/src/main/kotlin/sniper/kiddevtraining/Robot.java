package sniper.kiddevtraining;

import android.graphics.Rect;

import java.util.ArrayList;

import sniper.kiddevtraining.code_render_view.Dimen;
import sniper.kiddevtraining.code_render_view.game_interfaces.GameDimensions;

/**
 * Created by sniper on 10/16/16.
 */

public class Robot {
    // Constants are Here
    final int JUMP_SPEED = -15;
    final int MOVE_SPEED = 5;

    private Dimen robotDimens;
    private int centerX;
    //    private int centerX = 100;
    private int centerY;
    //    private int centerY = 377;
    private boolean jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;
    private boolean readyToFire = true;
    private static boolean isDead;

    private int speedX = 0;
    private int speedY = 0;
    public static Rect rect = new Rect(0, 0, 0, 0);
    public static Rect rect2 = new Rect(0, 0, 0, 0);
    public static Rect rect3 = new Rect(0, 0, 0, 0);
    public static Rect rect4 = new Rect(0, 0, 0, 0);
    public static Rect yellowRed = new Rect(0, 0, 0, 0);

    public static Rect footLeft = new Rect(0,0,0,0);
    public static Rect footRight = new Rect(0,0,0,0);


//    private Background bg1 = GameScreen.getBg1();
//    private Background bg2 = GameScreen.getBg2();

    private ArrayList<Projectile> projectiles = new ArrayList<>();

    public Robot(GameDimensions dimens){
        this.robotDimens = dimens.getHeroDimension();
        centerX = 500;
        centerY = dimens.getBackgroundDimension().getHeight() - (GameSettings.LEVEL_BOTTOM_HEIGHT * dimens.getTileDimension().getHeight()) - (dimens.getHeroDimension().getHeight()/2);
        centerY = 500;
//        Set GameOver Y position based on Images dimensions
        GameSettings.GAME_OVER_Y_POSITION = dimens.getBackgroundDimension().getHeight() - (GameSettings.LEVEL_BOTTOM_HEIGHT * dimens.getTileDimension().getHeight());
    }
    public void update() {
        // Moves Character or Scrolls Background accordingly.

        if (speedX < 0) {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0) {
//            bg1.setSpeedX(0);
//            bg2.setSpeedX(0);
        }
        if (centerX <= 200 && speedX > 0) {
            centerX += speedX;
        }
        if (speedX > 0 && centerX > 200) {
//            bg1.setSpeedX((isMovingRight()) ? (-MOVE_SPEED / 5) : (MOVE_SPEED / 5));
//            bg2.setSpeedX((isMovingRight()) ? (-MOVE_SPEED / 5) : (MOVE_SPEED / 5));

//            bg2.setSpeedX(-MOVE_SPEED / 5);
        }

        // Updates Y Position
//        centerY += speedY;

        // Handles Jumping

//        speedY += 1;

        if (speedY > 3){
            jumped = true;
        }

        // Prevents going beyond X coordinate of 0
        if (centerX + speedX <= ((robotDimens.getWidth()/2) - 2) ) {
            centerX = (robotDimens.getWidth() / 2);
        }

        rect.set(centerX - 34, centerY - 63, centerX + 34, centerY);
        rect2.set(rect.left, rect.top + 63, rect.left+68, rect.top + 128);
        rect3.set(rect.left - 26, rect.top+32, rect.left, rect.top+52);
        rect4.set(rect.left + 68, rect.top+32, rect.left+94, rect.top+52);
        yellowRed.set(centerX - 110, centerY - 110, centerX + 70, centerY + 70);
        footLeft.set(centerX - 50, centerY + 20, centerX, centerY + 35);
        footRight.set(centerX, centerY + 20, centerX + 50, centerY + 35);


    }

    public void moveRight() {
        if (ducked == false) {
            speedX = MOVE_SPEED;
        }
    }

    public void moveLeft() {
        if (ducked == false) {
            speedX = -MOVE_SPEED;
        }
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    private void stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            speedX = 0;
        }

        if (isMovingRight() == false && isMovingLeft() == true) {
            moveLeft();
        }

        if (isMovingRight() == true && isMovingLeft() == false) {
            moveRight();
        }

    }

    public void jump() {
        if (jumped == false) {
            speedY = JUMP_SPEED;
            jumped = true;
        }

    }

    public void shoot() {
        if (readyToFire) {
            Projectile p = new Projectile(centerX + 50, centerY - 25);
            projectiles.add(p);
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isJumped() {
        return jumped;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isDucked() {
        return ducked;
    }

    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

    public static boolean isDead(){return isDead;}
    public static void setDead(boolean dead){isDead = dead;}

}
