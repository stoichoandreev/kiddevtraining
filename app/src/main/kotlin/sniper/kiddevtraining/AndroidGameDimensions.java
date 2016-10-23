package sniper.kiddevtraining;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import java.io.IOException;
import java.io.InputStream;

import sniper.kiddevtraining.code_render_view.Dimen;
import sniper.kiddevtraining.code_render_view.game_interfaces.GameDimensions;
import sniper.kiddevtraining.code_render_view.game_interfaces.Graphics;

/**
 * Created by sniper on 5/20/15.
 */
public class AndroidGameDimensions implements GameDimensions {

    private Dimen deviceDimens;
    private Dimen frameBufferDimens;
    private Dimen backgroundDimens;
    private Dimen heroDimens;
    private Dimen enemyDimens;
    private Dimen tileDimens;
    private Dimen buttonsDimens;
    private float density;

    public AndroidGameDimensions(Context context){
        boolean isPortrait = context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        density = displayMetrics.density;

        float dpHeight = displayMetrics.heightPixels;
//        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels;
//        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int frameBufferWidth = isPortrait ? (int)dpHeight: (int)dpWidth;
//        int frameBufferWidth = isPortrait ? 800: 1280;
        int frameBufferHeight = isPortrait ? (int)dpWidth: (int)dpHeight;
//        int frameBufferHeight = isPortrait ? 1280: 800;
        deviceDimens = new Dimen(frameBufferWidth,frameBufferHeight);
        frameBufferDimens = new Dimen(frameBufferWidth,frameBufferHeight);

//        BitmapFactory.Options o = new BitmapFactory.Options();
//        o.inTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
//        context.getAssets()
//        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.sample_image, o);
//        int w = bmp.getWidth();
//        int h = bmp.getHeight();
        Bitmap background = getBitmap(context, "background.png", Graphics.ImageFormat.RGB565);
        Bitmap hero = getBitmap(context, "jumped.png",Graphics.ImageFormat.ARGB4444);
        Bitmap enemy = getBitmap(context, "heliboy.png",Graphics.ImageFormat.ARGB4444);
        Bitmap tile = getBitmap(context, "tiledirt.png",Graphics.ImageFormat.ARGB4444);
        Bitmap buttons = getBitmap(context, "buttons.png",Graphics.ImageFormat.RGB565);
        backgroundDimens = new Dimen(background.getWidth(),background.getHeight());
        heroDimens = new Dimen(hero.getWidth(),hero.getHeight());
        enemyDimens = new Dimen(enemy.getWidth(),enemy.getHeight());
        tileDimens = new Dimen(tile.getWidth(),tile.getHeight());
        buttonsDimens = new Dimen(buttons.getWidth(),buttons.getHeight());

    }
    public Bitmap getBitmap(Context cont, String fileName, Graphics.ImageFormat format) {
        Bitmap.Config config = null;
        if (format == Graphics.ImageFormat.RGB565)
            config = Bitmap.Config.RGB_565;
        else if (format == Graphics.ImageFormat.ARGB4444)
            config = Bitmap.Config.ARGB_4444;
        else
            config = Bitmap.Config.ARGB_8888;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;


        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = cont.getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

//        if (bitmap.getConfig() == Bitmap.Config.RGB_565)
//            format = Graphics.ImageFormat.RGB565;
//        else if (bitmap.getConfig() == Bitmap.Config.ARGB_4444)
//            format = Graphics.ImageFormat.ARGB4444;
//        else
//            format = Graphics.ImageFormat.ARGB8888;

        return bitmap;
    }
    @Override
    public Dimen getDeviceDimension() {
        return deviceDimens;
    }

    @Override
    public Dimen getFrameBufferDimension() {
        return frameBufferDimens;
    }

    @Override
    public Dimen getBackgroundDimension() {
        return backgroundDimens;
    }

    @Override
    public Dimen getEnemyDimension() {
        return enemyDimens;
    }

    @Override
    public Dimen getHeroDimension() {
        return heroDimens;
    }

    @Override
    public Dimen getTileDimension() {
        return tileDimens;
    }

    @Override
    public Dimen getButtonsDimension() {
        return buttonsDimens;
    }
    @Override
    public float getDensity(){return density;}
}
