package com.tassioauad.builditbigger.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.tassioauad.builditbigger.R;
import com.tassioauad.builditbigger.api.JokeAsyncTask;
import com.tassioauad.builditbigger.api.OnJokeListener;
import com.tassioauad.jokeandroidlib.JokeActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @Bind(R.id.button_getjoke)
    Button buttonGetJoke;

    @Bind(R.id.adview)
    AdView adView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        buttonGetJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeAsyncTask(new OnJokeListener() {
                    @Override
                    public void onGetJoke(String joke) {
                        startActivity(JokeActivity.newIntent(getActivity(), joke));
                    }
                }).execute();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        return view;
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();

        return mainFragment;
    }
}
