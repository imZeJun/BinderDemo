package com.demo.lizejun.binderdemo.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {

    private Object delegate;

    public SubjectInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long beforeT = System.currentTimeMillis();
        method.invoke(delegate, args);
        Log.d("Proxy", "executeTime=" + (System.currentTimeMillis() - beforeT));
        return null;
    }

}
