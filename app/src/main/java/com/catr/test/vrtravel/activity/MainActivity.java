package com.catr.test.vrtravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.catr.test.vrtravel.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 启动Activity，并finish（）
        Intent i = new Intent(this, PanoListActivity_Backup.class);
        startActivity(i);
        //结束LaunchActivity
        finish();
    }
}
