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
	// View ������
	// IGirlView iGirlView;
	protected WeakReference<T> mReference;// ʹ��������,�����ڴ�й©
	// Model������
	IGirlModel iGirlModel = new GirlModelImpl();
	public GirlPresenter() {
		super();
//		this.mReference = new WeakReference<T>(view);
	}

	public void feach() {
		if (iGirlModel != null && mReference.get() != null) {
			// ��ʾ������
			if (mReference.get() != null) {
				mReference.get().showDialog();
			}
			SystemClock.sleep(2000);// Android�����ߣ��Ѻ������жϵ��쳣
			// ��������
			iGirlModel.loadGirl(new onGirlListener() {
				@Override
				public void onComplete(List<Girl> list) {
					// ��������
					// ��ʾ��View��
					if (mReference.get() != null) {
						mReference.get().showGirls(list);
					}
				}
			});

		}
	}

	/**
	 * ������Viewģ�ͣ�������Activity��Fragment������onTachActivity()
	 */
	public void attachView(T view) {
		mReference = new WeakReference<T>(view);
	}

	/**
	 * �Ͽ���Viewģ�͵����ӣ�������Activity��Fragment�ĶϿ�ondeTachActivity() ��ֹ������һЩ���õ�����
	 */
	public void detachView() {
		if (mReference != null) {
			mReference.clear();
		}
	}
}
