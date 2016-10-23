package sniper.kiddevtraining.code_render_view.game_interfaces

/**
 * Created by sniper on 7/10/14.
 */
interface Music {
    fun play()

    fun stop()

    fun pause()

    fun setVolume(volume: Float)

    val isPlaying: Boolean

    val isStopped: Boolean

    var isLooping: Boolean

    fun dispose()

    fun seekBegin()
    fun resume()
}

