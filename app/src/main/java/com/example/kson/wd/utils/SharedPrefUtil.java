package com.example.kson.wd.utils;

import android.content.SharedPreferences;

import com.example.kson.wd.App;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/13
 * Description:
 */
public class SharedPrefUtil {

    private static String tag = SharedPrefUtil.class.getSimpleName();
    private final static String SP_NAME = "data";
    private static SharedPreferences sp;


    public static void saveBoolean( String key, boolean value) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().putBoolean(key, value).commit();
    }


    public static void saveString(String key, String value) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().putString(key, value).commit();

    }

    public static void clear() {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().clear().commit();
    }


    public static void saveLong(String key, long value) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().putLong(key, value).commit();
    }


    public static void saveInt( String key, int value) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().putInt(key, value).commit();
    }


    public static void saveFloat( String key, float value) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        sp.edit().putFloat(key, value).commit();
    }


    public static String getString( String key, String defValue) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        return sp.getString(key, defValue);
    }


    public static int getInt(String key, int defValue) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        return sp.getInt(key, defValue);
    }


    public static long getLong( String key, long defValue) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        return sp.getLong(key, defValue);
    }


    public static float getFloat(String key, float defValue) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        return sp.getFloat(key, defValue);
    }


    public static boolean getBoolean(String key,boolean defValue) {
        if (sp == null)
            sp = App.mContext.getSharedPreferences(SP_NAME, 0);
        return sp.getBoolean(key, defValue);
    }
}
