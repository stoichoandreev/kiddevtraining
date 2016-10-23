package sniper.kiddevtraining.code_render_view.game_interfaces


/**
 * Created by sniper on 7/10/14.
 */
interface Image {
    val width: Int
    val height: Int
    val format: Graphics.ImageFormat
    fun dispose()
}
