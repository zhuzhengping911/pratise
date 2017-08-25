package com.zzp.pratise.proxy.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhengping.zhu
 * on 2017/8/25.
 */
public class CGLibProxy implements org.springframework.cglib.proxy.MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("MethodInterceptor start...");

        Object result = methodProxy.invokeSuper(o,objects);

        System.out.println("MethodInterceptor ending...");

        return result;
    }
}
