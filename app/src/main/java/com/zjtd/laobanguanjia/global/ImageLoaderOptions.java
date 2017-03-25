package com.zjtd.laobanguanjia.global;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zjtd.laobanguanjia.R;

public interface ImageLoaderOptions {
	// 圆角的配置项
	DisplayImageOptions round_options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.mipmap.text)
			.showImageForEmptyUri(R.mipmap.text)
			.showImageOnFail(R.mipmap.text)
			.cacheInMemory(true)
			.cacheOnDisk(true)
			.imageScaleType(ImageScaleType.EXACTLY)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.considerExifParams(true)
			// .displayer(new FadeInBitmapDisplayer(500)).build();
			.displayer(new RoundedBitmapDisplayer(28)).build();

	// 渐渐显示的配置项
	DisplayImageOptions fadein_options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.mipmap.text)
			.showImageForEmptyUri(R.mipmap.text)
			.showImageOnFail(R.mipmap.text)
			.cacheInMemory(false)
			.cacheOnDisk(true)
			.imageScaleType(ImageScaleType.EXACTLY)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.considerExifParams(true)
			.displayer(new FadeInBitmapDisplayer(500)).build();
	// .displayer(new RoundedBitmapDisplayer(28)).build();
}
