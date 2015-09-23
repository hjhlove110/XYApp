package com.sven.xinyao.ui;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SeracheView extends HttpSupportActivity {

	@ViewInject(R.id.s_msg)
	private EditText s_msg;
	@ViewInject(R.id.listView)
	private ListView listView;

	private String[] infos = { "飞机大战", "360安全卫士", "真心话大冒险", "蓝猫淘气3000问" };
	private final static int resultCode = 1;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.serache_view);
		context = this;
		initViews();
		setOnListener();
	}

	private void setOnListener() {
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent mIntent = new Intent();
				mIntent.putExtra("s_msg", infos[position]);
				setResult(resultCode, mIntent);
				finish();
			}
		});

	}

	private void initViews() {
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.gravity = Gravity.TOP;
		getWindow().setAttributes(lp);
		ViewUtils.inject(this);
		listView.setAdapter(new SeracheAdapter());
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}

	class SeracheAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = View.inflate(context, R.layout.serach_cell, null);
			}
			((TextView) convertView.findViewById(R.id.s_title))
					.setText(infos[position]);
			return convertView;
		}
	}
}
