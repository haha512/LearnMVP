package com.example.mvp_1.model;

import java.util.ArrayList;
import java.util.List;

import com.example.mvp_1.R;
import com.example.mvp_1.bean.Girl;


/**
 * ҵ��ģ�͸ı䣬�����µ�ҵ��ģ�ͣ���ǰ�Ǵӱ��ؼ������ݣ����ڴ������������
 * ͬ�����������Ҫ�ı������µ�Viewģ�ͣ��绻��GridView��ʾ
 * @author yuxue
 *
 */
public class GirlModelImplV2 implements IGirlModel {


	@Override
	public void loadGirl(onGirlListener listener) {
		//ģ�����������������
		//��������
		List<Girl> list=new ArrayList<Girl>();
		list.add(new Girl(R.drawable.image1, "0�����ҵ�Сƻ��image1"));
		list.add(new Girl(R.drawable.image2, "0�����ҵ�Сƻ��image2"));
		list.add(new Girl(R.drawable.image3, "0�����ҵ�Сƻ��image3"));
		list.add(new Girl(R.drawable.image4, "0�����ҵ�Сƻ��image4"));
		list.add(new Girl(R.drawable.image5, "0�����ҵ�Сƻ��image5"));
		list.add(new Girl(R.drawable.image6, "0�����ҵ�Сƻ��image6"));
		list.add(new Girl(R.drawable.image7, "0�����ҵ�Сƻ��image7"));
		list.add(new Girl(R.drawable.image8, "0�����ҵ�Сƻ��image8"));
		//��������
		listener.onComplete(list);
		
	}

}
