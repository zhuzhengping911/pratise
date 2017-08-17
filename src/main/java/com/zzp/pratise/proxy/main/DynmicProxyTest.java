package com.zzp.pratise.proxy.main;

import com.zzp.pratise.proxy.pojo.Target;
import com.zzp.pratise.proxy.pojo.TargetImpl;
import com.zzp.pratise.proxy.proxy.DynamicProxyHandler;

import java.lang.reflect.Proxy;


/**
 * Created by zhuzhengping
 * on 2017/8/18.
 *
 * 动态代理
 */
public class DynmicProxyTest {

    /**
     * 动态代理主要是通过反射机制，
     * 在运行时动态生成所需代理的class.
     * @param args
     */
    public static void main(String[] args) {

        Target target = new TargetImpl();

        DynamicProxyHandler handler = new DynamicProxyHandler(target);

        Target proxySubject = (Target) Proxy.newProxyInstance(
                TargetImpl.class.getClassLoader(),
                TargetImpl.class.getInterfaces(),
                handler
        );

        String result = proxySubject.excute();

        System.out.println(result);
    }
}
