package sniper.kiddevtraining.code_render_view.game_interfaces


import android.graphics.Paint

/**
 * Created by sniper on 7/10/14.
 */
interface Graphics {
    enum class ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

    fun newImage(fileName: String, format: ImageFormat): Image

    fun clearScreen(color: Int)

    fun drawLine(x: Int, y: Int, x2: Int, y2: Int, color: Int)

    fun drawRect(x: Int, y: Int, width: Int, height: Int, color: Int)

    fun drawImage(image: Image, x: Int, y: Int, srcX: Int, srcY: Int,
                  srcWidth: Int, srcHeight: Int)

    fun drawImage(Image: Image, x: Int, y: Int)

    fun drawString(text: String, x: Int, y: Int, paint: Paint)

    val width: Int

    val height: Int

    fun drawARGB(i: Int, j: Int, k: Int, l: Int)

}

