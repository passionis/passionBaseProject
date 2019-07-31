package com.passion.mainmoudle.splash;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.passion.mainmoudle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 欢迎页面
 */
public class SplashActivity extends AppCompatActivity {

    private List<Integer> pictures = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_splash);
        pictures.add(R.mipmap.main_guide_background_1);
        pictures.add(R.mipmap.main_guide_background_2);
        pictures.add(R.mipmap.main_guide_background_3);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpage);
        SplashViewPageAdapter adapter = new SplashViewPageAdapter(pictures, this);
        viewPager.setAdapter(adapter);

    }
}
