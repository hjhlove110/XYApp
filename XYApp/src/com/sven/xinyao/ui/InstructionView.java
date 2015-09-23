package com.sven.xinyao.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class InstructionView extends HttpSupportActivity {
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.btnRight)
	private ImageButton btnRight;
	@ViewInject(R.id.webView)
	private WebView webView;
	private ProgressDialog dialog;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction_view);
		context = this;
		ViewUtils.inject(this);
		initViews();
	}

	private void initViews() {
		dialog = new ProgressDialog(context);
		dialog.setMessage("������...");
		
		String tit = getIntent().getStringExtra("title");
		if (tit.endsWith("1")) {
			title.setVisibility(View.INVISIBLE);
			btnRight.setVisibility(View.VISIBLE);
		} else {
			title.setText(tit);
		}
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				dialog.dismiss();
			}
		});

		webView.loadUrl("http://www.baidu.com");
		dialog.show();
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}

	@OnClick(R.id.btnRight)
	public void ShareInfo(View v) {
		LogUtils.d("url=" + webView.getUrl());
		showShare("��������", "������Ϣ");
	}

	private void showShare(String msg, String myMsg) {
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();
		// �ر�sso��Ȩ
		oks.disableSSOWhenAuthorize();

		// ����ʱNotification��ͼ������� 2.5.9�Ժ�İ汾�����ô˷���
		// oks.setNotification(R.drawable.ic_launcher,
		// getString(R.string.app_name));
		// title���⣬ӡ��ʼǡ����䡢��Ϣ��΢�š���������QQ�ռ�ʹ��
		oks.setTitle(getString(R.string.share));
		// titleUrl�Ǳ�����������ӣ�������������QQ�ռ�ʹ��
		oks.setTitleUrl("http://sharesdk.cn");
		// text�Ƿ����ı�������ƽ̨����Ҫ����ֶ�
		oks.setText(msg);
		// imagePath��ͼƬ�ı���·����Linked-In�����ƽ̨��֧�ִ˲���
		oks.setImagePath("/sdcard/test.jpg");// ȷ��SDcard������ڴ���ͼƬ
		// url����΢�ţ��������Ѻ�����Ȧ����ʹ��
		oks.setUrl("http://sharesdk.cn");
		// comment���Ҷ�������������ۣ�������������QQ�ռ�ʹ��
		oks.setComment(myMsg);
		// site�Ƿ�������ݵ���վ���ƣ�����QQ�ռ�ʹ��
		oks.setSite(getString(R.string.app_name));
		// siteUrl�Ƿ�������ݵ���վ��ַ������QQ�ռ�ʹ��
		oks.setSiteUrl("http://sharesdk.cn");

		// ��������GUI
		oks.show(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
			} else {
				finish();
			}
		}
		return true;
	}
}
