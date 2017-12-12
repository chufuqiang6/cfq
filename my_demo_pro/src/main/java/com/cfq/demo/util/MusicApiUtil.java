package com.cfq.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MusicApiUtil {
	private void query2(final String title){  
        new Thread(new Runnable() {  
            public void run() {  
                try {  
                    HttpURLConnection connection;  
                    String finalTitle = URLEncoder.encode("A Night in Goa","utf-8");  
                    URL url = new URL("http://music.baidu.com/search?key="+finalTitle);  
                    connection = (HttpURLConnection) url.openConnection();  
                    connection.setConnectTimeout(60*1000);  
                    connection.setReadTimeout(60*1000);  
                    connection.connect();  
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
                    String s;  
                    if ((s=reader.readLine())!=null) 
                    	 System.out.println(s);
//                        doJson(s);  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
    } 
	public static void main(String[] args) {
		MusicApiUtil aa=new MusicApiUtil();
		aa.query2("");
	}
}
