package com.bin.loading;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class Loading  {
	
	private Context context ;
	private ImageView big;
	private ImageView small;
	private View view;
	public  Loading(Context context) {
		this.context = context;
	}
	
	public View initConfig(){
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		manager.getDefaultDisplay().getMetrics(dm);
		view = View.inflate(context, R.layout.loadview, null);
		big = (ImageView) view.findViewById(R.id.big);
		small = (ImageView) view.findViewById(R.id.small);
		LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		params.leftMargin = dm.widthPixels /2 - 25; 
		big.setLayoutParams(params);
		LayoutParams params2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params2.addRule(RelativeLayout.CENTER_VERTICAL);
		params2.leftMargin = dm.widthPixels /2 + 25; 
		small.setLayoutParams(params2);
		startAnimation();
		return view;
	}
	
	
	private void startAnimation(){
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator animator = ObjectAnimator.ofFloat(big, "alpha", 0.2f, 1f , 0.2f);
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(small, "alpha", 1f, 0.2f, 1f);
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotation", 0, 359);
		ObjectAnimator animator4 = ObjectAnimator.ofFloat(big, "scaleX", 0.2f, 1.4f,0.2f);
		ObjectAnimator animator5 = ObjectAnimator.ofFloat(small, "scaleX", 1.4f, 0.2f,1.4f);
		ObjectAnimator animator6 = ObjectAnimator.ofFloat(big, "scaleY", 0.2f, 1.4f,0.2f);
		ObjectAnimator animator7 = ObjectAnimator.ofFloat(small, "scaleY", 1.4f, 0.2f,1.4f);
		animator.setRepeatCount(Integer.MAX_VALUE);
		animator2.setRepeatCount(Integer.MAX_VALUE);
		animator3.setRepeatCount(Integer.MAX_VALUE);
		animator4.setRepeatCount(Integer.MAX_VALUE);
		animator5.setRepeatCount(Integer.MAX_VALUE);
		animator6.setRepeatCount(Integer.MAX_VALUE);
		animator7.setRepeatCount(Integer.MAX_VALUE);
		animator3.setDuration(10000);
		animator.setDuration(2000);
		animator2.setDuration(2000);
		animator4.setDuration(2000);
		animator5.setDuration(2000);
		animator6.setDuration(2000);
		animator7.setDuration(2000);
		set.setInterpolator(new LinearInterpolator());//²»Í£¶Ù  
		set.play(animator).with(animator2).with(animator3).with(animator4).with(animator5).with(animator6).with(animator7);
		set.start();
		
	}
	
}
