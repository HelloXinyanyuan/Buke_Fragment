package com.whunf.viewpagerdemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */
public class MyPagerAdapter extends PagerAdapter {

    List<View> views;

    int[] imgResids;

    public MyPagerAdapter(List<View> views,int[] imgResids){
        this.views=views;

        this.imgResids=imgResids;
    }

    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//实例化某一个item view
        View view = views.get(position);

       // Context context=container.getContext();
//        BitmapFactory.Options option=new BitmapFactory.Options();
//        option.inPreferredConfig= Bitmap.Config.RGB_565;
//        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),imgResids[position],option);
//        view.setBackgroundDrawable(new BitmapDrawable(bitmap));
view.setBackgroundResource(imgResids[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = views.get(position);
        container.removeView(v);
    }
}
