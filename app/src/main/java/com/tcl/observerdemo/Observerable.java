package com.tcl.observerdemo;

/**
 * 项目名：   ObserverDemo
 * 包名：     com.tcl.observerdemo
 * 文件名：   Observerable
 * 创建者：   70889
 * 创建时间： 2018/5/7 17:01
 * 描述：     TODO
 */

public interface Observerable {
    //观察者注册
    public void registerObserver(Observer observer);
    //观察者移除
    public void removeObserver(Observer observer);
    //通知观察者更新
    public void notifyObserver();
}
