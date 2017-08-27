package com.zzp.pratise.proxy.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhengping.zhu
 * on 2017/8/25.
 */
public class CGLibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        
        System.out.println("MethodInterceptor start...");

        Object result = methodProxy.invokeSuper(o,objects);

        System.out.println("MethodInterceptor ending...");

        return result;
    }
}
