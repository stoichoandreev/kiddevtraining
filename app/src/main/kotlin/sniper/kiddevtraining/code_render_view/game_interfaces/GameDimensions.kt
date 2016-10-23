package sniper.kiddevtraining.code_render_view.game_interfaces

import sniper.kiddevtraining.code_render_view.Dimen

/**
 * Created by sniper on 10/16/16.
 */

interface GameDimensions {
    val deviceDimension: Dimen
    val frameBufferDimension: Dimen
    val backgroundDimension: Dimen
    val enemyDimension: Dimen
    val heroDimension: Dimen
    val tileDimension: Dimen
    val buttonsDimension: Dimen
    val density: Float
}
