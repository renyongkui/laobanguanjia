package com.zjtd.laobanguanjia.utils;

import android.graphics.drawable.Drawable;

import com.zjtd.laobanguanjia.global.App;


public class CommonUtil {
    /**
     * 在主线程执行任务
     */
    public static void runOnUIThread(Runnable r) {
        App.mainHandler.post(r);
    }

    /**
     * 获取字符串资源
     *
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return App.context.getResources().getString(resId);
    }

    public static String[] getStringArray(int resId) {
        return App.context.getResources().getStringArray(resId);
    }

    public static Drawable getDrawable(int resId) {
        return App.context.getResources().getDrawable(resId);
    }

    public static int getColor(int resId) {
        return App.context.getResources().getColor(resId);
    }

    /**
     * 从dimens.xml中获取dp资源，并且会自动将dp转为px
     *
     * @param resId
     * @return
     */
    public static int getDimens(int resId) {
        return App.context.getResources().getDimensionPixelSize(resId);
    }
}
