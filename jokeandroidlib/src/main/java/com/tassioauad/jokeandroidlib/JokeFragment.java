package com.tassioauad.jokeandroidlib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    private static final String ARG_JOKE = "argjoke";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        String joke = (String) getArguments().get(ARG_JOKE);
        ((TextView) view.findViewById(R.id.textview_joke)).setText(joke);

        return view;
    }

    public static JokeFragment newInstance(String joke) {
        JokeFragment jokeFragment = new JokeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_JOKE, joke);
        jokeFragment.setArguments(bundle);

        return jokeFragment;
    }

}
