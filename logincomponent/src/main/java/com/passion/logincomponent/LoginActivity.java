package com.passion.logincomponent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;


@Route(path = "/loginmoudle/login")
public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
//        TextView text = (TextView) findViewById(R.id.text);
//        String name = getIntent().getStringExtra("name");
//        long aLong = getIntent().getLongExtra("long", 0L);
//        Bundle bundle = getIntent().getBundleExtra("bundle");
//        String aaa = bundle.getString("aaa");
//        text.setText("name = " + name + "\b\n aLong = " + aLong + "\b\n bundle:string aa =" + aaa);


        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "aaaa");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
