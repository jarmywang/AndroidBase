package com.commons.support.img;


import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

/**
 * Created by qianjin on 2015/9/23.
 */
public abstract class ImageLoadListener {

    public void onLoadingStarted(String imageUri, View view) {
    }
    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
    }
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
    }
    public void onLoadingCancelled(String imageUri, View view) {
    }

}
