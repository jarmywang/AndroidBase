package com.commons.support.log;

/**
 * 调试日志类
 * Created by qianjin on 2015/4/14.
 */
public class LogUtil {
    public static void log(String msg) {
        //if (BuildConfig.LOG_DEBUG) {
            System.out.println("=== " + msg + " ===");
        //}
    }
    public static void error(String msg) {
        //if (BuildConfig.LOG_DEBUG) {
            System.err.println("=== " + msg + " ===");
        //}
    }
}
