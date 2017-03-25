package com.zjtd.laobanguanjia.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zjtd.laobanguanjia.R;


public abstract class BaseActivity extends FragmentActivity {
    protected FrameLayout fl_body;
    protected TextView tv_title;
    protected TextView tv_right;
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseActivity.this;

        initView();
        initData();


    }


    /**
     * 初始化view
     */
    protected void initView() {
        setContentView(R.layout.base_activity);
        tv_title = (TextView) getView(R.id.tv_title);
        tv_right = (TextView) getView(R.id.tv_right);
        fl_body = (FrameLayout) getView(R.id.fl_body);
        fl_body.addView(rootView());

    }

    /**
     * 初始化布局
     *
     * @return
     */
    protected abstract View rootView();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 获取控件
     *
     * @param id
     * @return
     */
    protected View getView(int id) {
        return findViewById(id);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitles(CharSequence title) {
        tv_title.setVisibility(View.VISIBLE);
        tv_title.setText(title);
    }

    /**
     * 设置右边按钮
     */
    public void setRight(CharSequence title) {
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(title);
    }

    @Override
    protected void onDestroy() {
        outAnim();
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        outAnim();
    }


    // activity切换进入动画
    protected void inAnim() {
        overridePendingTransition(R.anim.anim_next_enter, R.anim.anim_next_exit);
    }

    // activity切换退出动画
    protected void outAnim() {
        overridePendingTransition(R.anim.anim_pre_enter, R.anim.anim_pre_exit);
    }


}
