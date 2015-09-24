package com.commons.support.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by qianjin on 2015/9/23.
 */
public class ImageLoader {
    public static void init(Context context){
        //init imageLoader
        DisplayImageOptions defaultOptions =
                new DisplayImageOptions
                        .Builder().cacheInMemory(true).cacheOnDisk(true)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .imageScaleType(ImageScaleType.EXACTLY) // default
                        .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions).build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config);
    }

    public static void loadImage(String url,ImageView iv){
        getImageLoader().displayImage(url, iv);
    }

    public static void loadImage(String url,ImageView iv, final ImageLoadListener listener){
        if (listener == null) {
            loadImage(url,iv);
        } else {
            getImageLoader().displayImage(url, iv, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    listener.onLoadingStarted(imageUri,view);
                }
                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    listener.onLoadingFailed(imageUri,view,failReason);
                }
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    listener.onLoadingComplete(imageUri,view,loadedImage);
                }
                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    listener.onLoadingCancelled(imageUri,view);
                }
            });
        }
    }




    private static com.nostra13.universalimageloader.core.ImageLoader getImageLoader(){
        return com.nostra13.universalimageloader.core.ImageLoader.getInstance();
    }



}
