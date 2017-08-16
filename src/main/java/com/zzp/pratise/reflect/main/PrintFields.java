package com.zzp.pratise.reflect.main;

import com.zzp.pratise.reflect.pojo.SonClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by zhuzhengping
 * on 2017/8/16.
 * 通过反射获取所有的变量
 */
public class PrintFields {

    public static void main(String[] args) {
        Class mClass = SonClass.class;
        //1.获取并输出类的名称
        System.out.println(mClass.getName());
        //2.1 获取所有 public 访问权限的变量
        Field[] fields = mClass.getFields();
        //2.2 获取所有本类声明的变量（不问访问权限
        Field[] sonFileds = mClass.getDeclaredFields();
        //3. 遍历变量并输出变量信息
        for (Field field : fields){
            //获取访问权限并输出  包括本类声明的和从父类继承的
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());
        }
        System.out.println("==========================");
        for (Field field : sonFileds){
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print("sonField: " + Modifier.toString(modifiers) + "");
            //输出变量的类型及变量名
            System.out.println("sonField: " + field.getType().getName() + " " + field.getName());
        }
    }
}
