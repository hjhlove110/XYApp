package com.sven.xinyao.ui;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.sven.xinyao.utils.MyHttpClient;

public class HttpSupportActivity extends Activity {
	private HttpUtils httpUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		httpUtils = MyHttpClient.getInstance();
	}

	public void HttpRequest(String url, RequestParams params,
			final ProgressDialog dialog) {
		HttpUtils.sHttpCache.clear();
		httpUtils.send(HttpMethod.POST, url, new RequestCallBack<String>() {
			@Override
			public void onStart() {
				if (null != dialog) {
					dialog.show();
				}
				super.onStart();
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				if (null != dialog) {
					dialog.dismiss();
				}
				ToastUtil("�����쳣");
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				if (null != dialog) {
					dialog.dismiss();
				}
				try {
					JSONObject result = new JSONObject(arg0.result);
					OnSuccess(result);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void OnSuccess(JSONObject result) {

	}

	public void ToastUtil(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	public void TurnActivity(Class<?> a, boolean isFinish) {
		startActivity(new Intent(getApplicationContext(), a));
		if (isFinish) {
			finish();
		}
	}

	public void back(View v) {
		finish();
	}
}