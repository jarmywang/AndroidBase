package com.androidbase;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.commons.support.db.config.Config;
import com.commons.support.db.config.ConfigUtil;
import com.commons.support.img.ImageLoadListener;
import com.commons.support.img.ImageLoader;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = new ImageView(this);
        ImageLoader.loadImage("", iv, new ImageLoadListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
            }
        });

        //测试
        //select * from seeds where seeds.title like ‘%测试%’ limit 0,10；


        ConfigUtil.save(new Config("test", "this is a value"));
        String value = ConfigUtil.getConfigValue("test");
        printLog(value);



    }

}
