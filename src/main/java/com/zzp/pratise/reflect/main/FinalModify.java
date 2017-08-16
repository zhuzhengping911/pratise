package com.zzp.pratise.reflect.main;

import com.zzp.pratise.reflect.pojo.FinalClass;

import java.lang.reflect.Field;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 */
public class FinalModify {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //1. 获取 Class 类实例
        FinalClass privateClass = new FinalClass();
        Class mClass = FinalClass.class;

        //2. 获取私有常量
        Field fieldFinal = mClass.getDeclaredField("FINAL_VALUE");
        Field fieldFinalChose = mClass.getDeclaredField("FINAL_VALUE_CHOSE");
        Field fieldFinalModify = mClass.getDeclaredField("FINAL_VALUE_MODIFY");
        //3. 修改常量的值
        if(fieldFinal != null){
            fieldFinal.setAccessible(true);
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改前的值
            System.out.println("Before Modify：FINAL_VALUE = " + fieldFinal.get(privateClass));
            //修改私有常量
            fieldFinal.set(privateClass,"ZZP");
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改后的值
            System.out.println("After Modify：FINAL_VALUE = " + fieldFinal.get(privateClass));
            // 获取值并输出
            System.out.println("Actually Modify：FINAL_VALUE = " + privateClass.getFINAL_VALUE());
        }

        System.out.println("================");


        if(fieldFinalChose != null){
            fieldFinalChose.setAccessible(true);
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE_CHOSE 修改前的值
            System.out.println("Before Modify：FINAL_VALUE_CHOSE = " + fieldFinalChose.get(privateClass));
            //修改私有常量
            fieldFinalChose.set(privateClass,"ZZP");
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE_CHOSE 修改后的值
            System.out.println("After Modify：FINAL_VALUE_CHOSE = " + fieldFinalChose.get(privateClass));           //使用对象调用类的 getter 方法
            // 获取值并输出
            System.out.println("Actually Modify：FINAL_VALUE_CHOSE = " + privateClass.getFINAL_VALUE_CHOSE());
        }

        System.out.println("================");

        if(fieldFinalModify != null){
            fieldFinalModify.setAccessible(true);
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE_MODIFY 修改前的值
            System.out.println("Before Modify：FINAL_VALUE_MODIFY = " + fieldFinalModify.get(privateClass));
            //修改私有常量
            fieldFinalModify.set(privateClass,"ZZP");
            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE_MODIFY 修改后的值
            System.out.println("After Modify：FINAL_VALUE_MODIFY = " + fieldFinalModify.get(privateClass));
            //使用对象调用类的 getter 方法
            // 获取值并输出
            System.out.println("Actually Modify：FINAL_VALUE_MODIFY = " + privateClass.getFINAL_VALUE_MODIFY());
        }
    }
}
