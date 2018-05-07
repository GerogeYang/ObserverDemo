package com.tcl.observerdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：   ObserverDemo
 * 包名：     com.tcl.observerdemo
 * 文件名：   ButtonListener
 * 创建者：   70889
 * 创建时间： 2018/5/7 17:57
 * 描述：     TODO
 */

public class ButtonListener implements Observerable {
    private static final String TAG = ButtonObserver.class.getName();
    private List<Observer> observerList = null;
    private String message = null;

    public ButtonListener() {
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.i(TAG, "registerObserver: observerList.size() = "+observerList.size());
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Log.i(TAG, "removeObserver: observerList.size() = "+observerList.size());
        if (!observerList.isEmpty() && observerList.contains(observer)) {
            observer.update(null);
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        Log.i(TAG, "notifyObserver: observerList.size() = "+observerList.size());
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer = observerList.get(i);
            observer.update(message);
        }
    }

    public void sendMessage(String message) {
        Log.i(TAG, "sendMessage: message = " + message);
        this.message = message;
        System.out.println("message = " + message);
        notifyObserver();
    }
}
