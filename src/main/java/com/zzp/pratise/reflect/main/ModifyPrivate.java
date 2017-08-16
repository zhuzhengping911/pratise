package com.zzp.pratise.reflect.main;

import com.zzp.pratise.reflect.pojo.PrivateClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 * 访问对象的私有方法 * 为简洁代码，在方法上抛出总的异常，实际开发别这样
 */
public class ModifyPrivate {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //1. 获取 Class 类实例
        PrivateClass privateClass = new PrivateClass();
        Class mClass = PrivateClass.class;

        //2. 获取私有方法
        //第一个参数为要获取的私有方法的名称
        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        //方法参数也可这么写 ：new Class[]{String.class , int.class}
        Method privateMethod = mClass.getDeclaredMethod("privateMethod", String.class, int.class);

        //3. 开始操作方法

        if (privateMethod != null) {
        //获取私有方法的访问权
        //只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);
        //使用 invoke 反射调用私有方法
        //privateMethod 是获取到的私有方法
        //testClass 要操作的对象
        //后面两个参数传实参
            privateMethod.invoke(privateClass, "Java Reflect ", 666);
        }
        System.out.println("=============");
        //2. 获取私有变量
        Field field = mClass.getDeclaredField("Msg");
        //3. 操作私有变量
        if(field != null){
            field.setAccessible(true);
            System.out.println("Before Modify：MSG = " + privateClass.getMsg());
            //调用 set(object , value) 修改变量的值
            //privateField 是获取到的私有变量
            //testClass 要操作的对象
            //"Modified" 为要修改成的值
            field.set(privateClass,"Modify");
            System.out.println("After Modify：MSG = " + privateClass.getMsg());
        }

    }

}
