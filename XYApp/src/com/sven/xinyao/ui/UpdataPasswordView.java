package com.sven.xinyao.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.sven.xinyao.ui.R;

public class UpdataPasswordView extends HttpSupportActivity {
	@ViewInject(R.id.title)
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updata_password_view);
		ViewUtils.inject(this);
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}

	@OnClick(R.id.sendMsg)
	public void sendMsg(View v) {
		SendSMS(((Button)v).getText().toString(), "");
	}

	/**
	 * 调起系统发短信功能
	 * 
	 * @param phoneNumber
	 *            发送短信的接收号码
	 * @param message
	 *            短信内容
	 */
	public void SendSMS(String phoneNumber, String message) {
		Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"
				+ phoneNumber));
		intent.putExtra("sms_body", message);
		startActivity(intent);
	}
}
