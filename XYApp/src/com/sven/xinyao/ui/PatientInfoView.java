package com.sven.xinyao.ui;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PatientInfoView extends HttpSupportActivity {
	@ViewInject(R.id.listView)
	private ListView listView;
	@ViewInject(R.id.title)
	private TextView title;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_info_view);
		context = this;
		ViewUtils.inject(this);
		initViews();
	}

	private void initViews() {
		title.setText("ªº’ﬂ–≈œ¢");
		listView.setAdapter(new PatientInfoAdapter());
	}

	class PatientInfoAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 3;
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
				convertView = View.inflate(context, R.layout.patient_info_cell,
						null);
			}
			return convertView;
		}
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}
}
