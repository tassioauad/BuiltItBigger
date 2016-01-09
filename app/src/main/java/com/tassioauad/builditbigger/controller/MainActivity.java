package com.tassioauad.builditbigger.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tassioauad.builditbigger.R;
import com.tassioauad.builditbigger.api.JokeAsyncTask;
import com.tassioauad.builditbigger.api.OnJokeListener;
import com.tassioauad.jokeandroidlib.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){
        new JokeAsyncTask(new OnJokeListener() {
            @Override
            public void onGetJoke(String joke) {
                startActivity(JokeActivity.newIntent(MainActivity.this, joke));
            }
        }).execute();
    }
}
