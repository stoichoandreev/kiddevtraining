package sniper.kiddevtraining.code_render_view.game_interfaces

import android.view.View.OnTouchListener


interface TouchHandler : OnTouchListener {
    fun isTouchDown(pointer: Int): Boolean

    fun getTouchX(pointer: Int): Int

    fun getTouchY(pointer: Int): Int

    val touchEvents: List<Input.TouchEvent>
}
