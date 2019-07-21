package com.passion.baseproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.passion.logincomponent.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "zy";

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e(TAG, "onCreate: " + button);

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Log.e(TAG, "onViewClicked: ");

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
