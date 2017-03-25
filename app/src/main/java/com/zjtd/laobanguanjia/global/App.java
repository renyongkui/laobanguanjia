package com.zjtd.laobanguanjia.global;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App extends Application {
    public static Context context;
    public static Handler mainHandler;
    //public User user = null;
    //public static Gson gson;

    /**
     * app的入口函数
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();
        //初始化ImageLoader,其实就是初始化缓存目录，内存缓存大小，磁盘缓存大小等
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    }


    public static Context getContext() {
        return context;
    }

    /**
     * 全局捕获异常
     */
    class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        //一旦出现未捕获的异常, 就会走此回调方法
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            ex.printStackTrace();
            //将错误日志保存在sdcard
            try {
                PrintWriter writer = new PrintWriter(Environment
                        .getExternalStorageDirectory().getAbsolutePath()
                        + "/errduobao.log");
                ex.printStackTrace(writer);
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            android.os.Process.killProcess(android.os.Process.myPid());

        }

    }

}
