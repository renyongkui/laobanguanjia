package com.zjtd.laobanguanjia.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.zjtd.laobanguanjia.R;
import com.zjtd.laobanguanjia.base.BaseFragment;

/**
 * Author：RenYongKui on 2016/5/17 11:53
 * Mailbox：783249414@qq.com
 */
public class ExchangeFragment extends BaseFragment {
    TextView ryk_tv_temp;
    private String s;

    @Override
    protected View getSuccessView() {
        View view = View.inflate(activity, R.layout.fragment_exchange, null);
        ryk_tv_temp = (TextView) view.findViewById(R.id.ryk_tv_temp);
        return view;
    }

    @Override
    protected Object requestData() {
        s = "我换大米";
        if (s!= null){
            ryk_tv_temp.setText(s);
        }
        return s;
    }
}
