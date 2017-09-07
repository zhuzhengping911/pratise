package com.zzp.pratise.Useful;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class ArrayToMap {

    public static void main(String[] args) {

//        17. 把 Array 转换成 Map
        String[][] countries = { { "United States", "New York" }, { "United Kingdom", "London" },
                { "Netherland", "Amsterdam" }, { "Japan", "Tokyo" }, { "France", "Paris" } };

        Map countryCapitals = ArrayUtils.toMap(countries);

        System.out.println("Capital of Japan is " + countryCapitals.get("Japan"));
        System.out.println("Capital of France is " + countryCapitals.get("France"));
    }
}
