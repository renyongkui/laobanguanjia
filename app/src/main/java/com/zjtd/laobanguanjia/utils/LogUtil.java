package com.zjtd.laobanguanjia.utils;

import android.util.Log;

/**
 * log管理类
 * @author Administrator
 *
 */
public class LogUtil {	
	private static boolean isDebug = true;//在app代码完成后置为false
	
	public static void d(String tag,String msg){
		if(isDebug){
			Log.d(tag, msg);
		}
	}
	public static void e(String tag,String msg){
		if(isDebug){
			Log.e(tag, msg);
		}
	}
	
	public static void d(Object object,String msg){
		if(isDebug){
			Log.d(object.getClass().getSimpleName(), msg);
		}
	}
	public static void e(Object object,String msg){
		if(isDebug){
			Log.e(object.getClass().getSimpleName(), msg);
		}
	}
}
