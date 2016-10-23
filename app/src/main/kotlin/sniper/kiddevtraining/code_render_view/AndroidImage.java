package sniper.kiddevtraining.code_render_view;

import android.graphics.Bitmap;

import sniper.kiddevtraining.code_render_view.game_interfaces.Graphics;
import sniper.kiddevtraining.code_render_view.game_interfaces.Image;


public class AndroidImage implements Image {
    Bitmap bitmap;
    Graphics.ImageFormat format;

    public AndroidImage(Bitmap bitmap, Graphics.ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}

