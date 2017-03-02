package com.example.mvp_1.presenter;

import java.util.List;

import android.os.SystemClock;

import com.example.mvp_1.bean.Girl;
import com.example.mvp_1.model.GirlModelImpl;
import com.example.mvp_1.model.IGirlModel;
import com.example.mvp_1.model.IGirlModel.onGirlListener;
import com.example.mvp_1.view.IGirlView;

public class GirlPresenterV2 extends BasePresenter<IGirlView> {
	
	
	//Model的引用
	IGirlModel iGirlModel=new GirlModelImpl();
	
	public GirlPresenterV2() {
		super();
//		this.mReference = new WeakReference<T>(view);
	}

	public void feach(){
		
		if (iGirlModel!=null&&getView()!=null) {
			//显示进度条
			if (getView()!=null) {
				getView().showDialog();
			}
			SystemClock.sleep(2000);// Android的休眠，已忽略了中断的异常
			//加载数据
			iGirlModel.loadGirl(new onGirlListener() {
				@Override
				public void onComplete(List<Girl> list) {
					//返回数据
					//显示到View层
					if (getView()!=null) {
						getView().showGirls(list);
					}
				}
			});
			
		}
		
		
	}

}
