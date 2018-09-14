package com.example.kson.wd;

import android.app.Application;
import android.content.Context;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/13
 * Description:
 */
public class App extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
