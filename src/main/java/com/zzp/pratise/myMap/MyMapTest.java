package com.zzp.pratise.myMap;

/**
 * Created by zhuzhengping
 * on 2017/8/28.
 */
public class MyMapTest {

    public static void main(String[] args) {
        MyMap<String,String> map = new MyMap<>();
        map.put("zzp","123");
        map.put("zzp1","321");
        map.put("zzp2","1234567");
        map.put("zzp3","abc");
        map.put("zzp3","bcd");

        System.out.println(map.size());
        System.out.println(map.get("zzp2"));
    }
}
