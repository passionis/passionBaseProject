package com.passion.mainmoudle.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.passion.mainmoudle.R;

import java.util.List;

/**
 * 欢迎页面viewpager适配器
 */
public class SplashViewPageAdapter extends PagerAdapter  {
    private List<Integer> pictures;

    private Context context;

    public SplashViewPageAdapter(List<Integer> pictures, Context context) {
        this.pictures = pictures;
        this.context = context;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.main_item_splash, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_main_item_splash);
        Glide.with(context).load(R.mipmap.main_guide_background_1).into(imageView);
        container.addView(view);    //这一步很重要
        return view;
    }

    @Override
    public int getCount() {
        return  pictures.size();
    }

    /*
     * 判断view是否当前需要的对象
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
