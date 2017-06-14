package com.demo.lizejun.binderdemo.proxy;

import android.util.Log;

public class RealSubject implements Subject {

    @Override
    public void dealTask(String task) {
        Log.d("Proxy", "dealTask=" + task);
    }
}
