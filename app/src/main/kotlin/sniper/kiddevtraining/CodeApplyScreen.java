package sniper.kiddevtraining;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

import sniper.kiddevtraining.code_render_view.Screen;
import sniper.kiddevtraining.code_render_view.game_interfaces.Game;
import sniper.kiddevtraining.code_render_view.game_interfaces.Graphics;
import sniper.kiddevtraining.code_render_view.game_interfaces.Image;

/**
 * Created by sniper on 10/16/16.
 */

public class CodeApplyScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

//    private static Background bg1, bg2;
    private static Robot hero;
//    public static Heliboy enemyOne, enemyTwo;

    private Image currentSprite, heroImageState, heroImageStateOne, heroImageStateTwo, heroImageStateThree;
    private Image enemyImageStateOne, enemyImageStateTwo, enemyImageStateThree, enemyImageStateFour, enemyImageStateFive;
    private Animation heroAnimation, enemyAnimation;

//    private ArrayList<Tile> tileArrayList;

    int livesLeft = 1;//variable for hero lives
    Paint paint, paint2;
    private int enemyYPosition;
    private int buttonsStartPosition;

    public CodeApplyScreen(Game game) {
        super(game);

//        prodaljawam ot tuk za da moga da oprawja razpolojenieto na wsi4ki obekti po ekrana

        // Initialize game objects here
//        tileArrayList = new ArrayList<Tile>();
//        bg1 = new Background(0, 0 , super.game.getMyGameDimensions().getBackgroundDimension());
//        bg2 = new Background(game.getMyGameDimensions().getBackgroundDimension().getWidth(), 0,game.getMyGameDimensions().getBackgroundDimension());
////        bg2 = new Background(2160, 0);
        hero = new Robot(game.getGameDimensions());
//        enemyYPosition = game.getMyGameDimensions().getBackgroundDimension().getHeight() - (GameSettings.LEVEL_BOTTOM_HEIGHT * game.getMyGameDimensions().getTileDimension().getHeight()) - (game.getMyGameDimensions().getEnemyDimension().getHeight() / 2);
//
//        enemyOne = new Heliboy(800, enemyYPosition);
//        enemyTwo = new Heliboy(1100, enemyYPosition);

        heroImageState = Assets.heroState;
        heroImageStateOne = Assets.heroStateOne;
        heroImageStateTwo = Assets.heroStateTwo;
        heroImageStateThree = Assets.heroStateThree;

        enemyImageStateOne = Assets.enemyStateOne;
        enemyImageStateTwo = Assets.enemyStateTwo;
        enemyImageStateThree = Assets.enemyStateThree;
        enemyImageStateFour = Assets.enemyStateFour;
        enemyImageStateFive = Assets.enemyStateFive;

        heroAnimation = new Animation();
        heroAnimation.addFrame(heroImageState, 350);
        heroAnimation.addFrame(heroImageStateOne, 50);
        heroAnimation.addFrame(heroImageStateTwo, 50);
        heroAnimation.addFrame(heroImageStateThree, 50);
        heroAnimation.addFrame(heroImageStateTwo, 50);
        heroAnimation.addFrame(heroImageStateOne, 50);

        enemyAnimation = new Animation();
        enemyAnimation.addFrame(enemyImageStateOne, 100);
        enemyAnimation.addFrame(enemyImageStateTwo, 100);
        enemyAnimation.addFrame(enemyImageStateThree, 100);
        enemyAnimation.addFrame(enemyImageStateFour, 100);
        enemyAnimation.addFrame(enemyImageStateFive, 100);
        enemyAnimation.addFrame(enemyImageStateFour, 100);
        enemyAnimation.addFrame(enemyImageStateThree, 100);
        enemyAnimation.addFrame(enemyImageStateTwo, 100);

        currentSprite = heroAnimation.getImage();

//        loadMap();

        // Defining a paint object
        paint = new Paint();
//        paint.setTextSize(20 * game.getMyGameDimensions().getDensity());
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        paint2 = new Paint();
//        paint2.setTextSize(35 * game.getMyGameDimensions().getDensity());
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.WHITE);

//        buttonsStartPosition = (game.getMyGameDimensions().getFrameBufferDimension().getHeight() / 2) - (int)(game.getMyGameDimensions().getButtonsDimension().getWidth() * 1.5);

    }

//    private void loadMap() {
//        ArrayList lines = new ArrayList();
//        int width = 0;
////        int height = 0;
//
//        Scanner scanner = new Scanner(SampleGame.map);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//
//            // no more lines to read
//            if (line == null) {
//                break;
//            }
//
//            if (!line.startsWith("!")) {
//                lines.add(line);
//                width = Math.max(width, line.length());
//
//            }
//        }
////        height = lines.size();
//        Tile.TILE_SIZE = game.getMyGameDimensions().getTileDimension().getWidth();
//
//        for (int j = 0; j < lines.size(); j++) {
////        for (int j = 0; j < 12; j++) {
//            String line = (String) lines.get(j);
//            for (int i = 0; i < width; i++) {
//                if (i < line.length()) {
//                    char ch = line.charAt(i);
//                    Tile t = new Tile(i, j, Character.getNumericValue(ch));
//                    tileArrayList.add(t);
//                }
//            }
//        }
//    }//end of load map

    @Override
    public void update(float deltaTime) {
//        List touchEvents = game.getMyInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        switch (state){
            case Ready:
                updateReady();
//                updateReady(touchEvents);
                break;
            case Running:
                updateRunning(deltaTime);
                break;
            case Paused:
//                updatePaused(touchEvents);
                break;
            case GameOver:
//                updateGameOver(touchEvents);
                break;
        }
//        if (state == GameState.Ready)
//            updateReady(touchEvents);
//        if (state == GameState.Running)
//            updateRunning(touchEvents, deltaTime);
//        if (state == GameState.Paused)
//            updatePaused(touchEvents);
//        if (state == GameState.GameOver)
//            updateGameOver(touchEvents);
    }

    private void updateReady() {
//    private void updateReady(List touchEvents) {

        // This example starts with a "Ready" myScreen.
        // When the user touches the myScreen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

//        if (touchEvents.size() > 0)
//            state = GameState.Running;

        state = GameState.Running;
    }

    private void updateRunning(float deltaTime) {
//    private void updateRunning(List touchEvents, float deltaTime) {

//        int controlWidth = game.getMyGameDimensions().getButtonsDimension().getWidth();
//
//        // 1. All touch myInput is handled here:
//        int len = touchEvents.size();
//        for (int i = 0; i < len; i++) {
//            TouchEvent event = (TouchEvent)touchEvents.get(i);
//            if (event.type == TouchEvent.TOUCH_DOWN) {
//
//                if (inBounds(event, 0, buttonsStartPosition, controlWidth, controlWidth)) {
//                    hero.jump();
//                    currentSprite = heroAnimation.getImage();
//                    hero.setDucked(false);
//                }
//
//                else if (inBounds(event, 0, buttonsStartPosition + controlWidth, controlWidth, controlWidth)) {
//
//                    if (hero.isDucked() == false && hero.isJumped() == false
//                            && hero.isReadyToFire()) {
//                        hero.shoot();
//                        Assets.shoot.play(GameSettings.GAME_SOUND_VOLUME_LEVEL);
//                    }
//                }
//
//                else if (inBounds(event, 0, buttonsStartPosition + (controlWidth * 2), controlWidth, controlWidth)
//                        && hero.isJumped() == false) {
//                    currentSprite = Assets.heroDown;
//                    hero.setDucked(true);
//                    hero.setSpeedX(0);
//
//                }
//
//                if (event.x > (game.getMyGameDimensions().getDeviceDimension().getWidth()/2) ) {
//                    // Move right.
                    hero.moveRight();
                    hero.setMovingRight(true);
//
//                }
////                TODO change here if there has a problem with hero moving left (back)
//                else if (event.x < (game.getMyGameDimensions().getDeviceDimension().getWidth()/2)){
//                    // Move left.
//                    hero.moveLeft();
//                    hero.setMovingLeft(true);
//                }
//
//            }
//
//            if (event.type == TouchEvent.TOUCH_UP) {
//
//                if (inBounds(event, 0, buttonsStartPosition + controlWidth , controlWidth, controlWidth)) {
//                    currentSprite = heroAnimation.getImage();
//                    hero.setDucked(false);
//
//                }
//
//                if (inBounds(event, 0, 0, 65, 60)) {
//                    pause();
//
//                }
//
//                if (event.x > (game.getMyGameDimensions().getDeviceDimension().getWidth()/2)) {
//                    // Move right.
//                    hero.stopRight();
//                }
//                else if (event.x < (game.getMyGameDimensions().getDeviceDimension().getWidth()/2)){
//                    //Stop move left
//                    hero.stopLeft();
//                }
//            }
//
//        }
//
//        // 2. Check miscellaneous events like death:
//
//        if (livesLeft == 0) {
//            state = GameState.GameOver;
//        }
//
//        // 3. Call individual update() methods here.
//        // This is where all the game updates happen.
//        // For example, hero.update();
        hero.update();
        if (hero.isJumped()) {
            currentSprite = Assets.heroJump;
        } else if (hero.isJumped() == false && hero.isDucked() == false) {
            currentSprite = heroAnimation.getImage();
        }

//        ArrayList projectiles = hero.getProjectiles();
//        for (int i = 0; i < projectiles.size(); i++) {
//            Projectile p = (Projectile) projectiles.get(i);
//            if (p.isVisible() == true) {
//                p.update();
//            } else {
//                projectiles.remove(i);
//            }
//        }
//
//        updateTiles();
//        enemyOne.update();
//        enemyTwo.update();
//        bg1.update();
//        bg2.update();
        animate();
//
        if (hero.getCenterY() > GameSettings.GAME_OVER_Y_POSITION || Robot.isDead()) {
            state = GameState.GameOver;
        }
    }

//    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
//        return (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) ? true : false;
//    }
//
//    private void updatePaused(List touchEvents) {
//        int len = touchEvents.size();
//        for (int i = 0; i < len; i++) {
//            TouchEvent event = (TouchEvent) touchEvents.get(i);
//            if (event.type == TouchEvent.TOUCH_UP) {
//                if (inBounds(event, 0, 0, game.getMyGameDimensions().getDeviceDimension().getWidth(), game.getMyGameDimensions().getDeviceDimension().getHeight() / 2)) {
//
//                    if (!inBounds(event, 0, 0, 35, 35)) {
//                        resume();
//                    }
//                }
//
//                if (inBounds(event, 0, (game.getMyGameDimensions().getDeviceDimension().getHeight() / 2), game.getMyGameDimensions().getDeviceDimension().getWidth(), (game.getMyGameDimensions().getDeviceDimension().getHeight() / 2))) {
//                    nullify();
//                    goToMenu();
//                }
//            }
//        }
//    }
//
//    private void updateGameOver(List touchEvents) {
//        int len = touchEvents.size();
//        for (int i = 0; i < len; i++) {
//            TouchEvent event = (TouchEvent)touchEvents.get(i);
//            if (event.type == TouchEvent.TOUCH_DOWN) {
//                if (inBounds(event, 0, 0, game.getMyGameDimensions().getDeviceDimension().getWidth(), game.getMyGameDimensions().getDeviceDimension().getHeight())) {
//                    nullify();
//                    game.setMyScreen(new MainMenuScreen(game));
//                    return;
//                }
//            }
//        }
//
//    }
//
//    private void updateTiles() {
//
//        for (int i = 0; i < tileArrayList.size(); i++) {
//            tileArrayList.get(i).update();
////            Tile t = tileArrayList.get(i);
////            t.update();
//        }
//
//    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
//      first  draw background on the Surface View
        g.clearScreen(Color.parseColor("#ffffff"));
//        g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
//
////      then draw all level tiles
//        paintTiles(g);
//
////        then draw hero bullets if has
//        ArrayList projectiles = hero.getProjectiles();
//        for (int i = 0; i < projectiles.size(); i++) {
//            Projectile p = (Projectile) projectiles.get(i);
//            g.drawRect(p.getX(), p.getY(), GameSettings.HERO_BULLET_WIDTH, GameSettings.HERO_BULLET_HEIGHT, GameSettings.HERO_BULLET_COLOR);
//        }
//        //  draw the game elements.
//
        g.drawImage(currentSprite, hero.getCenterX() - game.getGameDimensions().getHeroDimension().getWidth()/2,
                hero.getCenterY() - game.getGameDimensions().getHeroDimension().getHeight()/2);
//        g.drawImage(enemyAnimation.getImage(), enemyOne.getCenterX() - game.getMyGameDimensions().getEnemyDimension().getWidth()/2,
//                enemyOne.getCenterY() - game.getMyGameDimensions().getEnemyDimension().getHeight());
//        g.drawImage(enemyAnimation.getImage(), enemyTwo.getCenterX() - game.getMyGameDimensions().getEnemyDimension().getWidth()/2,
//                enemyTwo.getCenterY() - game.getMyGameDimensions().getEnemyDimension().getHeight());

        // Example:
        // g.drawImage(Assets.background, 0, 0);
//         g.drawImage(Assets.heroImageStateOne, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

//    private void paintTiles(Graphics g) {
//        for (int i = 0; i < tileArrayList.size(); i++) {
//            Tile t = tileArrayList.get(i);
//            if (t.type != 0) {
//                g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
//            }
//        }
//    }

    public void animate() {
        heroAnimation.update(10);
        enemyAnimation.update(50);
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 230, 0, 0);
        g.drawString("Hello",
                100,
                100,
                paint2);

    }

    private void drawRunningUI() {

//        TODO draw Game Control Images
//        int controlWidth = game.getMyGameDimensions().getButtonsDimension().getWidth();
//        Graphics g = game.getMyGraphics();
//        g.drawImage(Assets.button, 0, buttonsStartPosition, 0, 0, controlWidth, controlWidth);
////        g.drawImage(Assets.button, 0, game.getMyGameDimensions().getFrameBufferDimension().getHeight() - (game.getMyGameDimensions().getButtonsDimension().getHeight() * 3), 0, 0, game.getMyGameDimensions().getButtonsDimension().getWidth(), game.getMyGameDimensions().getButtonsDimension().getHeight());
//        g.drawImage(Assets.button, 0, buttonsStartPosition + controlWidth , 0, controlWidth, controlWidth, controlWidth);
//        g.drawImage(Assets.button, 0, buttonsStartPosition + (controlWidth * 2), 0, (controlWidth * 2), controlWidth, controlWidth + (int)(game.getMyGameDimensions().getDensity() * 3));
//        g.drawImage(Assets.button, 0, 0, 0, 340, 65, 60);

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
//        // Darken the entire myScreen so you can display the Paused myScreen.
//        g.drawARGB(155, 0, 0, 0);
//        g.drawString(((AndroidGame) game).getResources().getString(R.string.resume),
//                (game.getMyGameDimensions().getFrameBufferDimension().getWidth()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                (game.getMyGameDimensions().getFrameBufferDimension().getHeight()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                paint2);
//        g.drawString(((AndroidGame)game).getResources().getString(R.string.menu),
//                (game.getMyGameDimensions().getFrameBufferDimension().getWidth()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                (game.getMyGameDimensions().getFrameBufferDimension().getHeight()/2) + (int)(20*game.getMyGameDimensions().getDensity()),
//                paint2);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
//        g.drawRect(0, 0, game.getMyGameDimensions().getFrameBufferDimension().getWidth(),
//                game.getMyGameDimensions().getFrameBufferDimension().getHeight(),
//                GameSettings.GAME_OVER_BACKGROUND_COLOR);
//        g.drawString(((AndroidGame)game).getResources().getString(R.string.game_over),
//                (game.getMyGameDimensions().getFrameBufferDimension().getWidth()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                (game.getMyGameDimensions().getFrameBufferDimension().getHeight()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                paint2);
//        g.drawString(((AndroidGame)game).getResources().getString(R.string.tap_to_return),
//                (game.getMyGameDimensions().getFrameBufferDimension().getWidth()/2) - (int)(20*game.getMyGameDimensions().getDensity()),
//                (game.getMyGameDimensions().getFrameBufferDimension().getHeight()/2) + (int)(20*game.getMyGameDimensions().getDensity()),
//                paint);
    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {
        if (state == GameState.Paused)
            state = GameState.Running;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }

    private void nullify() {
//        Set all variables to null. You will be recreating them in the constructor.
        paint = null;
//        bg1 = null;
//        bg2 = null;
        hero = null;
//        enemyOne = null;
//        enemyTwo = null;
        currentSprite = null;
        heroImageStateOne = null;
        heroImageStateTwo = null;
        heroImageStateThree = null;
        enemyImageStateOne = null;
        enemyImageStateTwo = null;
        enemyImageStateThree = null;
        enemyImageStateFour = null;
        enemyImageStateFive = null;
        heroAnimation = null;
        enemyAnimation = null;
//        Robot.setDead(false);

//        Call garbage collector to clean up memory.
        System.gc();

    }

}
