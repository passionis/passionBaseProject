package com.passion.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/loginmoudle/update")
public class UpdateAccountActivity extends AppCompatActivity {

    @Autowired
    String name;

    @Autowired
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_update_account);
        ARouter.getInstance().inject(this);

        EditText login_edittext = (EditText) findViewById(R.id.login_edittext);
        login_edittext.setText(name + "---" + age);

    }
}
