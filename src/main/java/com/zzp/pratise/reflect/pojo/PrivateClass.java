package com.zzp.pratise.reflect.pojo;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 */
public class PrivateClass {

    private String Msg = "Original";

    public String getMsg() {
        return Msg;
    }

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);

    }
}
