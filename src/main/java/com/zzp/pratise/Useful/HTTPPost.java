package com.zzp.pratise.Useful;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class HTTPPost {

    public static void main(String[] args)  {
        //19. 发送代数据的HTTP 请求
        try {
            URL my_url = new URL("http://coolshell.cn/");
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while(null != (strTemp = br.readLine())){
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
