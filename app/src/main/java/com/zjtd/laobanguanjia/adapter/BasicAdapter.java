package com.zjtd.laobanguanjia.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.zjtd.laobanguanjia.base.BaseHolder;

import java.util.ArrayList;

public abstract class BasicAdapter<T> extends BaseAdapter {
    protected ArrayList<T> list;

    //alt+shift+s->o
    public BasicAdapter(ArrayList<T> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> holder = null;
        if (convertView == null) {
            //1.创建holder
            holder = getHolder(position);//需要holder对象，但是holder又不一样，所以通过方法来做这个事
        } else {
            //convertView在retur holderView的时候被初始化了，不是空的
            holder = (BaseHolder) convertView.getTag();
        }

        //4.绑定数据
        holder.bindData(list.get(position));

        View holderView = holder.getHolderView();
        //对holderView执行动画
        ViewHelper.setScaleX(holderView, 0.5f);
        ViewHelper.setScaleY(holderView, 0.5f);
        ViewPropertyAnimator.animate(holderView).scaleX(1.0f).setDuration(350)
                .setInterpolator(new OvershootInterpolator())
                .start();
        ViewPropertyAnimator.animate(holderView).scaleY(1.0f).setDuration(350)
                .setInterpolator(new OvershootInterpolator())
                .start();

        return holderView;//要返回holderView
    }

    /**
     * 获取holder对象，每个adapter的holder都不一样
     *
     * @return
     */
    public abstract BaseHolder<T> getHolder(int position);

}
