package com.commons.support.entity;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;


/**
 * Created by qianjin on 2015/4/30.
 */
public class Result {

    private boolean result;

    @JSONField(name = "resultcode")
    private String resultCode;

    private String msg;

    @JSONField(name = "errormsg")
    private String errorMsg;

    private String data;


    public String getDataStr(String key){
        if (!TextUtils.isEmpty(data)) {
            JSONObject obj = JSON.parseObject(data);
            String dataStr = obj.getString(key);
            return  dataStr;
        }
        return  "";
    }

    public int getDataInt(String key){
        if (!TextUtils.isEmpty(data)) {
            JSONObject obj = JSON.parseObject(data);
            int dataStr = obj.getIntValue(key);
            return  dataStr;
        }
        return  0;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
