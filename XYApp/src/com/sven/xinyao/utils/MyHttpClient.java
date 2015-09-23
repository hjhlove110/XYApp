package com.sven.xinyao.utils;

import com.lidroid.xutils.HttpUtils;

public class MyHttpClient {
	private static HttpUtils httpUtils;
	public static HttpUtils getInstance(){
		if (null == httpUtils) {
			httpUtils = new HttpUtils();
			httpUtils.configRequestRetryCount(3);
			httpUtils.configTimeout(10*1000);
		}
		return httpUtils;
	}
}
