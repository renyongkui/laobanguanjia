package com.zjtd.laobanguanjia.utils;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zjtd.laobanguanjia.R;

/**
 * 管理界面的加载逻辑
 *
 * @author Administrator
 */
public abstract class LoadingPage extends FrameLayout {

    //定义3种状态
    enum PageState {
        STATE_LOADING,//加载中的状态
        STATE_SUCCESS,//加载成功的状态
        STATE_ERROR;//加载失败的状态
    }

    //生成父类的构造方法：alt+shift+s->c
    public LoadingPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLoadingPage();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLoadingPage();
    }

    public LoadingPage(Context context) {
        super(context);
        initLoadingPage();
    }

    private View loadingView;//加载中对应的View
    private View errorView;//加载失败对应的View
    private View successView;//加载成功对应的View
    private PageState mState = PageState.STATE_LOADING;//当前界面的state默认是loading

    /**
     * 初始化LoadingPage
     */
    private void initLoadingPage() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //1.预先添加3个状态对应的View对象
        if (loadingView == null) {
            loadingView = View.inflate(getContext(), R.layout.page_loading, null);
        }
        addView(loadingView, params);

        if (errorView == null) {
            errorView = View.inflate(getContext(), R.layout.page_error, null);
            Button btn_reload = (Button) errorView.findViewById(R.id.btn_reload);
            btn_reload.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //1.先变为加载中
                    mState = PageState.STATE_LOADING;
                    showPage();

                    //2.重新请求数据，然后更新UI
                    loadDataAndRefreshPage();
                }
            });
        }
        addView(errorView, params);

        if (successView == null) {
            successView = createSuccessView();//需要successView
        }
        if (successView != null) {
            addView(successView, params);
        } else {
            throw new IllegalArgumentException("The method createSuccessView() can not return null!");
        }

        //2.根据当前的state，显示对应的view
        showPage();

        //3.去请求数据，然后根据请求回来的数据刷新界面
        loadDataAndRefreshPage();

    }

    /**
     * 请求数据，然后根据请求回来的数据刷新界面
     */
    public void loadDataAndRefreshPage() {
        new Thread() {
            public void run() {
                //1.获取请求的数据
                Object data = loadData();
                //2.根据返回的数据，去更新state,
                mState = (data == null ? PageState.STATE_ERROR : PageState.STATE_SUCCESS);
                //3.更新界面
                CommonUtil.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        showPage();
                    }
                });
            }
        }.start();
    }

    /**
     * 根据当前的state显示对应的view
     */
    private void showPage() {
        //1.一开始先隐藏所有的view
        loadingView.setVisibility(View.INVISIBLE);
        successView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.INVISIBLE);
        //2.谁的状态谁显示
        switch (mState) {
            case STATE_LOADING:
                loadingView.setVisibility(View.VISIBLE);
                break;
            case STATE_ERROR:
                errorView.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS:
                successView.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 由于每个界面的successView都不一样，所以由每个界面自己实现
     *
     * @return
     */
    protected abstract View createSuccessView();

    /**
     * 由于每个界面加载数据的过程都不一样，所以由每个界面去实现
     *
     * @return
     */
    protected abstract Object loadData();


}
