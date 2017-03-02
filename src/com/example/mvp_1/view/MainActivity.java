package com.example.mvp_1.view;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvp_1.R;
import com.example.mvp_1.adapter.GirlAdapter;
import com.example.mvp_1.bean.Girl;
import com.example.mvp_1.presenter.GirlPresenter;
import com.example.mvp_1.presenter.GirlPresenterV2;

public class MainActivity extends BaseActivity<IGirlView,GirlPresenterV2> implements IGirlView {
	ListView listView;
	GirlPresenter girlPresenter=new GirlPresenter<IGirlView>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		//girlPresenter.attachView(this);
		presenter.feach();

	}

	private void initView() {
		listView = (ListView) findViewById(R.id.listview);
	}

	@Override
	public void showDialog() {
		Toast.makeText(this, "正在加载数据中。。。", Toast.LENGTH_LONG).show();
	}

	@Override
	public void showGirls(List<Girl> list) {
		listView.setAdapter(new GirlAdapter(this, list));

	}
	@Override
	protected GirlPresenterV2 createPresenter() {
		return new GirlPresenterV2();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//girlPresenter.detachView();
	}
}
