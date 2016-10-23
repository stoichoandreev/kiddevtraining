package sniper.kiddevtraining.code_render_view.game_interfaces


import sniper.kiddevtraining.code_render_view.Screen

/**
 * Created by sniper on 7/10/14.
 */
interface Game {
    fun getAudio(): Audio
    fun getInput(): Input
    fun getFileIO(): FileIO
    fun getGraphics(): Graphics
    fun setScreen(screen: Screen)
    fun getCurrentScreen(): Screen
    fun getInitScreen(): Screen
    fun getGameDimensions(): GameDimensions
}

