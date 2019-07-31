package com.passion.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path =  "/loginmoudle/register")
public class RegiseterAcitivty extends AppCompatActivity {

    @Autowired
    String name;

    @Autowired
    String phone;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);

        setContentView(R.layout.login_activity_regiseter_acitivty);
    }
}
