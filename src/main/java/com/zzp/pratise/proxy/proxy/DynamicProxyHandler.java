package com.zzp.pratise.proxy.proxy;

import com.zzp.pratise.proxy.pojo.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 */
public class DynamicProxyHandler implements InvocationHandler{

    private Target target;

    public DynamicProxyHandler(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=====before=======");
        Object result = method.invoke(target,args);
        System.out.println("=====after========");
        return result;
    }
}
