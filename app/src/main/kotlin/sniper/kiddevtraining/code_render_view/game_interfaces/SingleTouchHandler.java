package sniper.kiddevtraining.code_render_view.game_interfaces;

import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class SingleTouchHandler implements TouchHandler {
    boolean isTouched;
    int touchX;
    int touchY;

    @Override
    public boolean isTouchDown(int pointer) {
        return false;
    }

    @Override
    public int getTouchX(int pointer) {
        return 0;
    }

    @Override
    public int getTouchY(int pointer) {
        return 0;
    }

    @Override
    public List<Input.TouchEvent> getTouchEvents() {
        return null;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
//    Pool<Input.TouchEvent> touchEventPool;
//    List<Input.TouchEvent> touchEvents = new ArrayList<>();
//    List<Input.TouchEvent> touchEventsBuffer = new ArrayList<>();
//    float scaleX;
//    float scaleY;
//
//    public SingleTouchHandler(View view, float scaleX, float scaleY) {
//        PoolObjectFactory<Input.TouchEvent> factory = new PoolObjectFactory<>() {
//            @Override
//            public Input.TouchEvent createObject() {
//                return new Input.TouchEvent();
//            }
//        };
//        touchEventPool = new Pool<TouchEvent>(factory, 100);
//        view.setOnTouchListener(this);
//
//        this.scaleX = scaleX;
//        this.scaleY = scaleY;
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        synchronized(this) {
//            TouchEvent touchEvent = touchEventPool.newObject();
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    touchEvent.type = TouchEvent.TOUCH_DOWN;
//                    isTouched = true;
//                    break;
//                case MotionEvent.ACTION_MOVE:
//                    touchEvent.type = TouchEvent.TOUCH_DRAGGED;
//                    isTouched = true;
//                    break;
//                case MotionEvent.ACTION_CANCEL:
//                case MotionEvent.ACTION_UP:
//                    touchEvent.type = TouchEvent.TOUCH_UP;
//                    isTouched = false;
//                    break;
//            }
//
//            touchEvent.x = touchX = (int)(event.getX() * scaleX);
//            touchEvent.y = touchY = (int)(event.getY() * scaleY);
//            touchEventsBuffer.add(touchEvent);
//
//            return true;
//        }
//    }
//
//    @Override
//    public boolean isTouchDown(int pointer) {
//        synchronized(this) {
//            if(pointer == 0)
//                return isTouched;
//            else
//                return false;
//        }
//    }
//
//    @Override
//    public int getTouchX(int pointer) {
//        synchronized(this) {
//            return touchX;
//        }
//    }
//
//    @Override
//    public int getTouchY(int pointer) {
//        synchronized(this) {
//            return touchY;
//        }
//    }
//
//    @Override
//    public List<Input.TouchEvent> getTouchEvents() {
//        synchronized(this) {
//            int len = touchEvents.size();
//            for( int i = 0; i < len; i++ )
//                touchEventPool.free(touchEvents.get(i));
//            touchEvents.clear();
//            touchEvents.addAll(touchEventsBuffer);
//            touchEventsBuffer.clear();
//            return touchEvents;
//        }
//    }
}
