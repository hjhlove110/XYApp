package com.sven.xinyao.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MyFootprint extends HttpSupportActivity {
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.listView)
	private ListView listView;

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_footprint);
		ViewUtils.inject(this);
		context = this;
		initViews();
	}

	private void initViews() {
		title.setText("ÎÒµÄ×ã¼£");
		listView.setAdapter(new FootPrintAdapter());
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}

	class FootPrintAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = View.inflate(context, R.layout.collection_cell,
						null);
			}
			return convertView;
		}
	}
}
