package com.zjtd.laobanguanjia.ui.fragment;

import android.view.View;

import com.zjtd.laobanguanjia.R;
import com.zjtd.laobanguanjia.base.BaseFragment;

/**
 * Author：RenYongKui on 2016/5/17 11:53
 * Mailbox：783249414@qq.com
 */
public class MineFragment extends BaseFragment{
private String temp = ""+0;

    @Override
    protected View getSuccessView() {

        return View.inflate(activity, R.layout.fragment_mine,null);
    }

    @Override
    protected Object requestData() {
        return temp;
    }
}
