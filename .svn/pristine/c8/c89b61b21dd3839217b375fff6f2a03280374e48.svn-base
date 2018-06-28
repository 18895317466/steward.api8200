package com.steward.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


import org.apache.commons.codec.digest.DigestUtils;


public class PushUtils {

	private static final String APPID = "A6935051107182";

	private static final String APPKEY = "EEDC387A-6DE1-DA65-92B6-A7B2D46713EE";

	public static String push(String str) {

		/**
		 * url : 'https://p.apicloud.com/api/push/message', method : "post",
		 * headers : { "X-APICloud-AppId" : "A690146020****",
		 * 				"X-APICloud-AppKey" : appKey }, 
		 * dataType : "json", 
		 * data : { 
		 * 		"values": { 
		 * 			"title" : "消息标题", 
		 * 			"content" : "消息内容", 
		 * 			"type" : 1, //– 消息类型，1:消息2:通知 
		 * 			"platform" : 0, //0:全部平台，1：ios, 2：android 
		 * 			// "groupName" :"department", //推送组名，多个组用英文逗号隔开.默认:全部组。eg.group1,group2 . 
		 * 			// "userIds" : "testId" //推送用户id, 多个用户用英文逗号分隔，eg. user1,user2。 
		 * 		} 
		 * 	}
		 * 
		 */

//		String str = "title=123456&content=111111&type=1&platform=0&department=&userIds=BD73B5BA-275D-4265-BCF1-A2A7921F9E61";

		HttpURLConnection conn = null;
		StringBuffer resultBuffer = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		String result = "";

		Long keyTime = new Date().getTime();

		try {
			URL realUrl = new URL("https://p.apicloud.com/api/push/message");
			// 打开和URL之间的连接
			conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
			conn.setRequestProperty("X-APICloud-AppId", APPID);
			conn.setRequestProperty("X-APICloud-AppKey",
					DigestUtils.shaHex(APPID + "UZ" + APPKEY + "UZ" + keyTime.toString()) + "." + keyTime.toString());

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);// post不能使用缓存

			conn.setRequestMethod("POST");

			// 获取URLConnection对象对应的输出流
			osw = new OutputStreamWriter(conn.getOutputStream());
			osw.write(str);
			osw.flush();

			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(conn.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (conn != null) {
						conn.disconnect();
						conn = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (conn != null) {
						conn.disconnect();
						conn = null;
					}
				}
			}

		}

		return resultBuffer.toString();
	}
	
	
	public static void main(String[] args) {
		Long keyTime = new Date().getTime();
		System.out.println(DigestUtils.shaHex(APPID + "UZ" + APPKEY + "UZ" + keyTime.toString()) + "." + keyTime.toString());
	}
}
