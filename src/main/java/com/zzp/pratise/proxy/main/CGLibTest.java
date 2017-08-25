package com.zzp.pratise.proxy.main;

import com.zzp.pratise.proxy.pojo.Target;
import com.zzp.pratise.proxy.pojo.TargetImpl;
import com.zzp.pratise.proxy.proxy.CGLibProxy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by zhengping.zhu
 * on 2017/8/25.
 *
 * 代理对象的生成过程由Enhancer类实现，大概步骤如下：
 1、生成代理类Class的二进制字节码；
 2、通过Class.forName加载二进制字节码，生成Class对象；
 3、通过反射机制获取实例构造，并初始化代理类对象。

 */
public class CGLibTest {

    public static void main(String[] args) {
        System.out.println("******************");

        TargetImpl target = new TargetImpl();

        CGLibTest test = new CGLibTest();

        TargetImpl proxyTarget = (TargetImpl) test.createProxy(TargetImpl.class);

        String res = proxyTarget.excute();

        System.out.println(res);

    }

    public Object createProxy(Class targetClass){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(targetClass);

        enhancer.setCallback(new CGLibProxy());

        return enhancer.create();
    }
}
