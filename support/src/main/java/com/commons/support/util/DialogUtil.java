package com.commons.support.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.commons.support.R;

/**
 * Created by qianjin on 2015/9/22.
 */
public class DialogUtil {


    public static AlertDialog createAlertConfirmDialog(
            Context context, String msg, DialogInterface.OnClickListener onClickListener) {

        TextView view = new TextView(context);
        view.setText("\n" + msg + "\n");
        view.setGravity(Gravity.CENTER);
        view.setTextSize(18);
        view.setPadding(20, 0, 20, 0);

        AlertDialog dialog = new AlertDialog
                .Builder(context)
                .setView(view)
                .setPositiveButton(context.getString(R.string.ok), onClickListener)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();

        return dialog;
    }

    public static AlertDialog createAlertInfoDialog(Context context, String title, String msg) {

        TextView view = new TextView(context);
        view.setText("\n" + msg + "\n");
        view.setGravity(Gravity.CENTER);
        view.setTextSize(18);
        view.setPadding(20, 0, 20, 0);

        return new AlertDialog.Builder(context).setView(view)
                .setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
    }

    public static Dialog createWaitingResultDialog(Context context,String tip) {
        View view = LayoutInflater.from(context).inflate(R.layout.waiting_result_dialog, null);
        TextView tvTip = (TextView) view.findViewById(R.id.tv_tip);
        tvTip.setText(tip);
        Dialog dialog = new AlertDialog.Builder(context).setView(view).create();
//        final Dialog Dialoglog = new Dialog(context, R.style.pay_result_dialog);
        dialog.setCancelable(false);
        return dialog;
    }


//    public static Dialog createConfirmDialog(final Context context, String msg, String msgContent, View.OnClickListener onClickListener) {
//        View view = LayoutInflater.from(context).inflate(R.layout.confirm_dialog, null);
//        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
//        TextView tvMsgContent = (TextView) view.findViewById(R.id.tv_msg_content);
//        tvMsg.setText(msg);
//        tvMsgContent.setText(msgContent);
//        final Dialog dialog = new Dialog(context, R.style.my_confirm_dialog);
//        dialog.setContentView(view);
//        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        view.findViewById(R.id.btn_ok).setOnClickListener(onClickListener);
//        return dialog;
//    }

    public static void createTipDialog(final Context context, String title, String msgContent) {
        View view = LayoutInflater.from(context).inflate(R.layout.tip_dialog, null);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg_title);
        TextView tvMsgContent = (TextView) view.findViewById(R.id.tv_msg_content);
        tvMsg.setText(title);
        tvMsgContent.setText(msgContent);
        final Dialog dialog = new Dialog(context, R.style.my_tip_dialog);
        dialog.setContentView(view);
        view.findViewById(R.id.btn_cancel).setVisibility(View.GONE);
        view.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static Dialog createTipDialog(final Context context, String title, String msgContent, View.OnClickListener listener) {
        View view = LayoutInflater.from(context).inflate(R.layout.tip_dialog, null);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg_title);
        TextView tvMsgContent = (TextView) view.findViewById(R.id.tv_msg_content);
        tvMsg.setText(title);
        tvMsgContent.setText(msgContent);
        final Dialog dialog = new Dialog(context, R.style.my_tip_dialog);
        dialog.setContentView(view);
        view.findViewById(R.id.btn_cancel).setVisibility(View.GONE);
        view.findViewById(R.id.btn_ok).setOnClickListener(listener);
        dialog.show();
        return dialog;
    }

    public static Dialog createLoadingDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);
        final Dialog dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(v);
        ((TextView) v.findViewById(R.id.dialog_context)).setText(msg);
        return dialog;
    }


}
