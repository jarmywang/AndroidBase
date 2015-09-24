package com.androidbase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.commons.support.log.LogUtil;
import com.commons.support.util.DialogUtil;

import org.json.JSONObject;

public class BaseFragment extends Fragment {

    public boolean isLoading = false;
    public Dialog loadingDialog;
    public View footer;
    public Activity context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
        loadingDialog = DialogUtil.createLoadingDialog(context, "加载中..");
    }

    public void startActivity(Class mClass){
        startActivity(new Intent(context, mClass));
    }

    protected void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public JSONObject getJsonObject(byte[] bytes) throws Exception {
        return new JSONObject(new String(bytes));
    }

    public void loadStart(boolean showFooter) {
        if (isLoading) {
            return;
        }
        if (showFooter) {
            footer.setVisibility(View.VISIBLE);
        } else {
            if (loadingDialog != null) {
                // loadingDialog.show();
            }
        }
        isLoading = true;
    }

    public void loadEnd() {
        isLoading = false;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        footer.setVisibility(View.GONE);
    }

    public void showToast(int drawable, String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(drawable);
        toastView.addView(imageView, 0);
        toast.show();
    }

    public void showToastCenter(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void printLog(String msg) {
        LogUtil.log(msg);
    }


}
