package com.zzp.pratise.reflect.pojo;

/**
 * Created by zhuzhengping
 * on 2017/8/16.
 */
public class SonClass {


    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    public void printSonMsg() {
        System.out.println("Son Msg - name : " + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name) {
        mSonName = name;
    }

    private void setSonAge(int age) {
        mSonAge = age;
    }

    private int getSonAge() {
        return mSonAge;
    }

    private String getSonName() {
        return mSonName;
    }
}
