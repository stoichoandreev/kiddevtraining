package sniper.kiddevtraining.code_render_view.game_interfaces

/**
 * Created by sniper on 7/10/14.
 */
interface Input {

    class TouchEvent {

        var type: Int = 0
        var x: Int = 0
        var y: Int = 0
        var pointer: Int = 0

        companion object {
            val TOUCH_DOWN = 0
            val TOUCH_UP = 1
            val TOUCH_DRAGGED = 2
            val TOUCH_HOLD = 3
        }


    }

    fun isTouchDown(pointer: Int): Boolean

    fun getTouchX(pointer: Int): Int

    fun getTouchY(pointer: Int): Int

    val touchEvents: List<TouchEvent>
}
