package com.zjtd.laobanguanjia.base;

import android.view.View;

public abstract class BaseHolder<T> {
	View holderView;//定义变量，记录view
	
	public BaseHolder(){
		//1.初始化View
		holderView = initView();
		//2.设置tag
		holderView.setTag(this);
	}
	
	/**
	 * 初始化View
	 * @return
	 */
	public abstract View initView();
	
	/**
	 * 绑定数据的方法
	 */
	public abstract void bindData(T t);
	
	
	public View getHolderView(){
		return holderView;
	}
}
