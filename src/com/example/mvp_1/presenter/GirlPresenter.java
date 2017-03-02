package com.example.mvp_1.presenter;

import java.lang.ref.WeakReference;
import java.util.List;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v4.app.Fragment;

import com.example.mvp_1.bean.Girl;
import com.example.mvp_1.model.GirlModelImpl;
import com.example.mvp_1.model.GirlModelImplV2;
import com.example.mvp_1.model.IGirlModel;
import com.example.mvp_1.model.IGirlModel.onGirlListener;
import com.example.mvp_1.view.IGirlView;

public class GirlPresenter<T extends IGirlView> {
	// View 的引用
	// IGirlView iGirlView;
	protected WeakReference<T> mReference;// 使用弱引用,避免内存泄漏
	// Model的引用
	IGirlModel iGirlModel = new GirlModelImpl();
	public GirlPresenter() {
		super();
//		this.mReference = new WeakReference<T>(view);
	}

	public void feach() {
		if (iGirlModel != null && mReference.get() != null) {
			// 显示进度条
			if (mReference.get() != null) {
				mReference.get().showDialog();
			}
			SystemClock.sleep(2000);// Android的休眠，已忽略了中断的异常
			// 加载数据
			iGirlModel.loadGirl(new onGirlListener() {
				@Override
				public void onComplete(List<Girl> list) {
					// 返回数据
					// 显示到View层
					if (mReference.get() != null) {
						mReference.get().showGirls(list);
					}
				}
			});

		}
	}

	/**
	 * 连接上View模型，类型于Activity与Fragment的连接onTachActivity()
	 */
	public void attachView(T view) {
		mReference = new WeakReference<T>(view);
	}

	/**
	 * 断开与View模型的连接，类型于Activity与Fragment的断开ondeTachActivity() 防止后面做一些无用的事情
	 */
	public void detachView() {
		if (mReference != null) {
			mReference.clear();
		}
	}
}
