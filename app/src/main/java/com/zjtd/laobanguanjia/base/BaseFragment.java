package com.zjtd.laobanguanjia.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.zjtd.laobanguanjia.utils.LoadingPage;

public abstract class BaseFragment extends Fragment {
    protected LoadingPage loadingPage;//注意：不能是private,因为private的变量子类无法共享
    protected Context activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        if (loadingPage == null) {
          //  LogUtil.e(this, this.getClass().getSimpleName() + "首次创建loadingPage");
            loadingPage = new LoadingPage(getActivity()) {
                @Override
                protected Object loadData() {
                    return requestData();
                }

                @Override
                protected View createSuccessView() {
                    //方法自己玩自己最终会报错：StackOverFlow（栈溢出）
                    return getSuccessView();
                }
            };
        } else {
            ViewParent parent = loadingPage.getParent();
            ViewGroup group = (ViewGroup) parent;
            group.removeView(loadingPage);
        }
        return loadingPage;
    }

    /**
     * 由每个子Fragment去实现,获取当前Fragment的successView
     *
     * @return
     */
    protected abstract View getSuccessView();

    /**
     * 由每个子Fragment去实现,获取当前Fragment的data
     *
     * @return
     */
    protected abstract Object requestData();

}	


