package com.zzp.pratise.proxy.pojo;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 */
public class TargetImpl implements Target{

    @Override
    public String excute() {

        System.out.println("TargetImpl execute！");
        
        return "execute";
    }
}
