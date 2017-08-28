package com.zzp.pratise.myMap;

import com.zzp.pratise.myMap.pojo.Person;

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

        MyMap<String,Person> personMyMap = new MyMap<String, Person>();
        personMyMap.put("First",new Person("Tom",25,"England"));
        personMyMap.put("Second",new Person("Eddie",26,"American"));
        personMyMap.put("Third",new Person("Marry",38,"China"));
        personMyMap.put("Fouth",new Person("Edward",12,"Japan"));
        personMyMap.put("Fifth",new Person("Jack",65,"Canada"));

        System.out.println("Total Person" + personMyMap.size());

        for (int index = 0 ; index < personMyMap.size(); index++){
            System.out.println("Person name:" + personMyMap.get(index).getName() + "\tPerson Age:" + personMyMap.get(index).getAge() + "\tPerson Coutry:" + personMyMap.get(index).getCountry());
        }

        System.out.println(personMyMap.get(6));
    }
}
