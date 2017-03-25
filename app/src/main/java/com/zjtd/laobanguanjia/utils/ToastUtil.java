
package com.zjtd.laobanguanjia.utils;


import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.zjtd.laobanguanjia.global.App;


public class ToastUtil {

    private static Toast toast;

    public static void show(Context context, String info) {
        show(info);
    }

    public static void show(Context context, int info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public synchronized static void show(String info) {
        if (toast == null) {
            toast = Toast.makeText(App.getContext(), info, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {

            toast.cancel();
            toast = null;
            toast = Toast.makeText(App.getContext(), info, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}
