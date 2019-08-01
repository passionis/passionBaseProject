package com.passion.mainmoudle.splash;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.passion.mainmoudle.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 欢迎页面
 */
public class SplashActivity extends AppCompatActivity {

    private List<ImageView> points = new ArrayList<>();
    private List<Integer> pictures = new ArrayList();
    private ViewPager viewPager;
    private LinearLayout pointll;
    private SplashViewPageAdapter adapter;
    private int currentPostion = 0;
    private Button launcherBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity_splash);
        initView();
        initData();
        initPoint();
        if (ObjectUtils.isNotEmpty(pictures)) {
            viewPager.setCurrentItem(currentPostion);
            points.get(currentPostion).setEnabled(true);
        }
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPostion + 1 < pictures.size()) {
                            viewPager.setCurrentItem(currentPostion + 1);
                        } else {
                            timer.cancel();
                            launcherBtn.setVisibility(View.VISIBLE);
                            pointll.setVisibility(View.GONE);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 2000, 2000);

    }

    private void initData() {
        pictures.add(R.mipmap.main_guide_background_1);
        pictures.add(R.mipmap.main_guide_background_2);
        pictures.add(R.mipmap.main_guide_background_3);
        adapter.notifyDataSetChanged();

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        pointll = (LinearLayout) findViewById(R.id.point_ll);
        launcherBtn = (Button) findViewById(R.id.launch_bt);
        adapter = new SplashViewPageAdapter(pictures, this);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                points.get(currentPostion).setEnabled(false);
                ImageView imageView = points.get(i);
                imageView.setEnabled(true);
                currentPostion = i;
                launcherBtn.setVisibility((i == pictures.size() - 1) ? View.VISIBLE : View.GONE);
                pointll.setVisibility((i != pictures.size() - 1) ? View.VISIBLE : View.GONE);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    /**
     * 创建并显示小圆点
     */
    private void initPoint() {
        pictures.forEach(c->{
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(getDrawable(R.drawable.main_splash_point));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SizeUtils.dp2px(15), SizeUtils.dp2px(15));
            params.setMargins(SizeUtils.dp2px(8), 0, 0, 0);
            imageView.setLayoutParams(params);
            imageView.setEnabled(false);
            points.add(imageView);
            pointll.addView(imageView);
        });

    }
}
