package com.tassioauad.jokeandroidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {


    private static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String joke = extras.getString(JokeActivity.EXTRA_JOKE);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_joke, JokeFragment.newInstance(joke)).commit();
        }

    }

}
