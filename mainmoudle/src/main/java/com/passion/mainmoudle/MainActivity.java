package com.passion.mainmoudle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.passion.mainmoudle.bean.User;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private int requestcode = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        Button button = findViewById(R.id.main_button2);
        Button main_button = findViewById(R.id.main_button);
        Button main_button3 = findViewById(R.id.main_button3);
        String uriStr = getIntent().getStringExtra(ARouter.RAW_URI);
        LogUtils.e(uriStr);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/loginmoudle/login")
                        .navigation();
            }
        });


        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("aaa", "aaa");

                ARouter.getInstance()
                        .build("/loginmoudle/login")
                        .withString("name", "string数据")
                        .withLong("long", 200L)
                        .withBundle("bundle", bundle)
                        .navigation();
            }
        });

        main_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/loginmoudle/login")
                        .navigation(MainActivity.this, requestcode);
            }
        });

        User user = new User();
        user.setAge("22");
        user.setName("ssss");

        ArrayList<User> users = new ArrayList<>();
        users.add(user);


        HashMap<String, User> map = new HashMap<>();
        map.put("1", user);


        Button main_button4 = (Button) findViewById(R.id.main_button4);
        main_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/loginmoudle/update")
                        .withString("name", "abc")
                        .withInt("age", 12)
//                        .withObject("object", user)
                        .navigation();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK) {
            Log.e("a", data.getStringExtra("result"));
        }
    }
}
