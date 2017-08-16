package com.zzp.pratise.reflect.main;

import com.zzp.pratise.reflect.pojo.SonClass;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by zhuzhengping
 * on 2017/8/16.
 *
 * 通过反射获取类的所有方法
 */
public class PrintMethods {

    public static void main(String[] args) {
        //1.获取并输出类的名称
        Class mclass = SonClass.class;
        System.out.println("类的名称：" + mclass.getName());
        //2.1 获取所有 public 访问权限的方法
        // 包括自己声明和从父类继承的
        Method[] methods = mclass.getMethods();
        //2.2 获取所有本类的的方法（不问访问权限）
        Method[] methods1 = mclass.getDeclaredMethods();

        for (Method method:methods){
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "( ");
            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters){
                System.out.println(parameter.getType().getName() + " " + parameter.getName() + ",");
            }
            //获取并输出方法抛出的异常
            Class[] exceptionType = method.getExceptionTypes();
            if(exceptionType.length == 0){
                System.out.println(" )");
            } else {
                for (Class c : exceptionType){
                    System.out.println(" ) throws " + c.getName());
                }
            }
            System.out.println();
        }

    }
}
