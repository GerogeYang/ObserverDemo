package com.tcl.observerdemo;

import android.util.Log;

/**
 * 项目名：   ObserverDemo
 * 包名：     com.tcl.observerdemo
 * 文件名：   ButtonObserver
 * 创建者：   70889
 * 创建时间： 2018/5/7 17:55
 * 描述：     TODO
 */

public class ButtonObserver implements Observer {
    private static final String TAG = ButtonObserver.class.getName();
    private String message = null;

    @Override
    public void update(String message) {
        Log.i(TAG, "update: message = "+message);
        this.message = message;
    }

    public String getMessage(){
        Log.i(TAG, "getMessage: message = "+message);
        return message;
    }
}
