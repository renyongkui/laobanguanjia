package com.zjtd.laobanguanjia.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zjtd.laobanguanjia.R;
import com.zjtd.laobanguanjia.adapter.BasicAdapter;

import java.util.ArrayList;


/**
 * 所有带有下拉刷新ListViw的父类
 *
 * @author Administrator
 */
public abstract class BaseRefreshListFragment<T> extends BaseFragment implements OnItemClickListener {
    protected PullToRefreshListView refreshListView;
    protected ListView listView;
    protected BasicAdapter<T> basicAdapter;
    protected ArrayList<T> list = new ArrayList<T>();

    @Override
    protected View getSuccessView() {
        refreshListView = (PullToRefreshListView) View.inflate(getActivity(),
                R.layout.ptr_listview, null);

        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {

            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // 直接请求
                loadingPage.loadDataAndRefreshPage();
            }
        });

        listView = refreshListView.getRefreshableView();
        listView.setSelector(android.R.color.transparent);
        addListHeader();
        basicAdapter = getAdapter();//需要一个adapter，让方法做这件事
        listView.setAdapter(basicAdapter);
        listView.setOnItemClickListener(this);
        return refreshListView;
    }

    /**
     * 获取adapter
     *
     * @return
     */
    protected abstract BasicAdapter<T> getAdapter();

    /**
     * 添加头布局的方法，需要就去实现
     */
    protected void addListHeader() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
    }

    @Override
    protected Object requestData() {
        return null;
    }

}
