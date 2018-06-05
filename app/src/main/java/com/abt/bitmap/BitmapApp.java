package com.abt.bitmap;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @描述： @BitmapApp
 * @作者： @黄卫旗
 * @创建时间： @05/06/2018
 */
public class BitmapApp extends Application {

    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
