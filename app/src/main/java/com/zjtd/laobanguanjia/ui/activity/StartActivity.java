package com.zjtd.laobanguanjia.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.zjtd.laobanguanjia.R;
import com.zjtd.laobanguanjia.base.BaseActivity;
import com.zjtd.laobanguanjia.base.FragmentFactory;
import com.zjtd.laobanguanjia.ui.fragment.ExchangeFragment;
import com.zjtd.laobanguanjia.ui.fragment.HealthLifeFragment;
import com.zjtd.laobanguanjia.ui.fragment.HomeFragment;
import com.zjtd.laobanguanjia.ui.fragment.MineFragment;

public class StartActivity extends BaseActivity {
    //@BindView(R.id.rg_content)
    RadioGroup rg_content;
    private HomeFragment homeFragment;
    private HealthLifeFragment healthLifeFragment;
    private ExchangeFragment exchangeFragment ;
    private MineFragment mineFragment;

    /**
     * 首页索引
     **/
    final int TAB_INDEX = 0;
    /**
     * 健康管家索引
     **/
    final int TAB_HEALTH = 1;
    /**
     * 垃圾换米索引
     **/
    final int TAB_EXCHANGE = 2;
    /**
     * 我的索引
     **/
    final int TAB_MINE = 3;
    /**
     * 当前展示的tab索引
     **/
    int mCurShowFragmentIndex;
    private FragmentTransaction transaction;

    @Override
    protected View rootView() {
        View view = View.inflate(mContext, R.layout.activity_start, null);
        return view;
    }

    @Override
    protected void initData() {
        rg_content = (RadioGroup) getView(R.id.rg_content);
        //ButterKnife.bind(this,view);
        rg_content.setOnCheckedChangeListener(new GuidCheckedChangeListennetr());
        rg_content.check(R.id.rb_home);
    }


    /**
     * 切换 tab选项卡
     *
     * @param tabItem
     */
    private void changeTab(final int tabItem) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (tabItem) {
            case TAB_INDEX:
                setTitles("首页");
                mCurShowFragmentIndex = TAB_INDEX;

                break;
            case TAB_HEALTH:
                setTitles("健康生活");
                mCurShowFragmentIndex = TAB_HEALTH;

                break;
            case TAB_EXCHANGE:
                setTitles("垃圾换米");
                mCurShowFragmentIndex = TAB_EXCHANGE;

                break;
            case TAB_MINE:
                setTitles("个人中心");
                mCurShowFragmentIndex = TAB_MINE;

                break;
        }
        transaction.replace(R.id.ryk_start_fl, FragmentFactory.create(tabItem));
        transaction.commit();
    }

    private class GuidCheckedChangeListennetr implements RadioGroup.OnCheckedChangeListener {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home://主页
                    changeTab(TAB_INDEX);
                    transaction.show(mineFragment);
                    break;
                case R.id.rb_healthy://健康生活
                    changeTab(TAB_HEALTH);
                    break;
                case R.id.rb_exchange://垃圾换米
                    changeTab(TAB_EXCHANGE);
                    break;
                case R.id.rb_mine://我的
                    changeTab(TAB_MINE);
                    break;
            }


        }
    }
}
