package com.abt.bitmap.large_image;

import android.content.Context;
import android.view.MotionEvent;

/**
 * @描述： @手势监视器基类
 * @作者： @黄卫旗
 * @创建时间： @04/07/2018
 */
public abstract class BaseGestureDetector {

    protected boolean mGestureInProgress;
    protected MotionEvent mPreMotionEvent;
    protected MotionEvent mCurrentMotionEvent;
    protected Context mContext;

    public BaseGestureDetector(Context context) {
        mContext = context;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!mGestureInProgress) {
            handleStartProgressEvent(event);
        } else {
            handleInProgressEvent(event);
        }
        return true;
    }

    protected abstract void handleInProgressEvent(MotionEvent event);

    protected abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);

    protected void resetState() {
        if (mPreMotionEvent != null) {
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }
        if (mCurrentMotionEvent != null) {
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }

}
