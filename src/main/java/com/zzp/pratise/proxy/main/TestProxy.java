package com.zzp.pratise.proxy.main;

import com.zzp.pratise.proxy.pojo.Target;
import com.zzp.pratise.proxy.pojo.TargetImpl;
import com.zzp.pratise.proxy.proxy.Proxy;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 *
 * 静态代理
 */
public class TestProxy {

    /**
     * 静态代理其实就是在程序运行之前，提前写好被代理方法的代理类，编译后运行。在程序运行之前，class已经存在。
     * 静态代理需要针对被代理的方法提前写好代理类，如果被代理的方法非常多则需要编写很多代码，
     * 因此，对于上述缺点，通过动态代理的方式进行了弥补。
     * @param args
     */
    public static void main(String[] args) {

        Target target = new TargetImpl();

        Proxy p = new Proxy(target);

        String result = p.excute();

        System.out.println(result);
    }
}
