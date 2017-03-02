package com.example.mvp_1.presenter;

import java.lang.ref.WeakReference;
// ����V:��ʾ��֮������Activity
public class BasePresenter<V> {
	//View ������
	protected WeakReference<V>mReference;//ʹ��������,�����ڴ�й©
	
	/**
	 * ������Viewģ�ͣ�������Activity��Fragment������onTachActivity()
	 * @param view
	 */
	public void attachView(V view){
		mReference=new WeakReference<V>(view);
	}
	/**
	 * �Ͽ���Viewģ�͵����ӣ�������Activity��Fragment�ĶϿ�ondeTachActivity()
	 * ��ֹ������һЩ���õ�����
	 * @param view
	 */
	public void detachView(){
		if (mReference!=null) {
			mReference.clear();
		}
	}
	protected V getView(){
		return mReference.get();
	}
}
