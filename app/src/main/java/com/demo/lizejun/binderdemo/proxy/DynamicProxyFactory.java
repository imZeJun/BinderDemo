package com.demo.lizejun.binderdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory {

    public static Subject createSubject() {
        Subject delegate = new RealSubject();
        InvocationHandler invocationHandler = new SubjectInvocationHandler(delegate);
        return  (Subject) Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), invocationHandler);
    }
}
