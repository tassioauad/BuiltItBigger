package com.tassioauad.builditbigger.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tassioauad.builditbigger.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_mainfragment, MainFragment.newInstance()).commit();
    }
}
