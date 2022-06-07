package com.stx.pro.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author RenBoQing
 * @date 2022年04月11日 14:18
 * @Description
 */
public class WxOpenIdUtils {
    public static String GET(String url) {
        String result = "";
        BufferedReader in = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            //构造url对象
            URL realUrl = new URL(url);
            //获取一个对应该URL的URLConnection对象
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常出现");
        }
        //关闭资源
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("出现异常");
            }
        }
        return result;
    }
}
