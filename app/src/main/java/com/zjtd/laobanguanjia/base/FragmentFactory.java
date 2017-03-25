package com.zjtd.laobanguanjia.base;

import android.support.v4.app.Fragment;

import com.zjtd.laobanguanjia.ui.fragment.ExchangeFragment;
import com.zjtd.laobanguanjia.ui.fragment.HealthLifeFragment;
import com.zjtd.laobanguanjia.ui.fragment.HomeFragment;
import com.zjtd.laobanguanjia.ui.fragment.MineFragment;

/**
 * 用来生产Fragment的类型
 *
 * @author Administrator
 */
public class FragmentFactory {
    /**
     * 根据不同的position生产对应的fragment对象
     *
     * @param position
     * @return
     */
    public static Fragment create(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new HealthLifeFragment();
                break;
            case 2:
                fragment = new ExchangeFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;
        }
        return fragment;
    }
}
