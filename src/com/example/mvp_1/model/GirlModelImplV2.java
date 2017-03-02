package com.example.mvp_1.model;

import java.util.ArrayList;
import java.util.List;

import com.example.mvp_1.R;
import com.example.mvp_1.bean.Girl;


/**
 * 业务模型改变，增加新的业务模型，以前是从本地加载数据，现在从网络加载数据
 * 同理，如果界面需要改变增加新的View模型，如换成GridView显示
 * @author yuxue
 *
 */
public class GirlModelImplV2 implements IGirlModel {


	@Override
	public void loadGirl(onGirlListener listener) {
		//模拟网络请求访问数据
		//加载数据
		List<Girl> list=new ArrayList<Girl>();
		list.add(new Girl(R.drawable.image1, "0你是我的小苹果image1"));
		list.add(new Girl(R.drawable.image2, "0你是我的小苹果image2"));
		list.add(new Girl(R.drawable.image3, "0你是我的小苹果image3"));
		list.add(new Girl(R.drawable.image4, "0你是我的小苹果image4"));
		list.add(new Girl(R.drawable.image5, "0你是我的小苹果image5"));
		list.add(new Girl(R.drawable.image6, "0你是我的小苹果image6"));
		list.add(new Girl(R.drawable.image7, "0你是我的小苹果image7"));
		list.add(new Girl(R.drawable.image8, "0你是我的小苹果image8"));
		//返回数据
		listener.onComplete(list);
		
	}

}
