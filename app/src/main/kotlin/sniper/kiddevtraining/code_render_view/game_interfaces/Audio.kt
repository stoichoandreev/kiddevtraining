package sniper.kiddevtraining.code_render_view.game_interfaces

/**
 * Created by sniper on 7/10/14.
 */
interface Audio {
    fun createMusic(file: String): Music
    fun createSound(file: String): Sound
    fun resumeMusic()
    fun pauseMusic()
    fun stopMusic()
}
