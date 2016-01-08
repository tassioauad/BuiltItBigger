package com.tassioauad.builditbigger.api;


import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.backend.jokeApi.JokeApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private JokeApi jokeApiService = null;

    private OnJokeListener listener;

    public JokeAsyncTask(OnJokeListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (jokeApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeApiService = builder.build();
        }
        try {
            return jokeApiService.joke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onGetJoke(result);
    }

}
