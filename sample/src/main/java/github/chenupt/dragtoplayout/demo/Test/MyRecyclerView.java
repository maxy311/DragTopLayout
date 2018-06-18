package github.chenupt.dragtoplayout.demo.Test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
        Log.e("wwwwwwwwaaa", "MyRecyclerView  dispatchTouchEvent " + dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(e);
        Log.e("wwwwwwwwaaa", "MyRecyclerView  onInterceptTouchEvent " + onInterceptTouchEvent);

        return onInterceptTouchEvent;
    }

//    @Override
//    public boolean onInterceptHoverEvent(MotionEvent event) {
//        boolean onInterceptHoverEvent = super.onInterceptHoverEvent(event);
//
//        Log.e("wwwwwwwwaaa", "MyRecyclerView  onInterceptHoverEvent " + onInterceptHoverEvent);
//        return onInterceptHoverEvent;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boolean onTouchEvent = super.onTouchEvent(e);
        Log.e("wwwwwwwwaaa", "MyRecyclerView  onTouchEvent " + onTouchEvent);
        return onTouchEvent;
    }

    public int getComputeVerticalScrollOffset() {
        return computeVerticalScrollOffset();
    }
}
