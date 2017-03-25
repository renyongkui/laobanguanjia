package com.zjtd.laobanguanjia.ui.fragment;

import android.view.View;

import com.zjtd.laobanguanjia.R;
import com.zjtd.laobanguanjia.base.BaseFragment;


/**
 * Author：RenYongKui on 2016/5/17 11:52
 * Mailbox：783249414@qq.com
 */
public class HomeFragment extends BaseFragment {


    @Override
    protected View getSuccessView() {
        return View.inflate(activity, R.layout.fragment_home,null);
    }

    @Override
    protected Object requestData() {

        return 1;
    }
}
