package com.zzp.pratise.proxy.proxy;

import com.zzp.pratise.proxy.pojo.Target;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 *
 * 静态代理
 */
public class Proxy implements Target{

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public String excute() {
        System.out.println("perProcess");

        String result = this.target.excute();

        System.out.println("postProcess");

        return result;
    }
}
