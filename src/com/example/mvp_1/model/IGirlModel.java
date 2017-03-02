package com.example.mvp_1.model;

import java.util.List;

import com.example.mvp_1.bean.Girl;

public interface IGirlModel {
	void loadGirl(onGirlListener listener);
	interface onGirlListener{
		void onComplete(List<Girl> list);
	}

}
