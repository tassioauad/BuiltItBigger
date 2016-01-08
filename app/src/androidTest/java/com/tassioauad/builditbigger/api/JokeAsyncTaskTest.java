package com.tassioauad.builditbigger.api;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;


public class JokeAsyncTaskTest extends AndroidTestCase {

    JokeAsyncTask jokeAsyncTask;

    public void testAGetJoke() {
        try {
            final CountDownLatch signal = new CountDownLatch(1);
            jokeAsyncTask = new JokeAsyncTask(new OnJokeListener() {
                @Override
                public void onGetJoke(String joke) {
                    assertNotNull(joke);
                    signal.countDown();
                }
            });

            jokeAsyncTask.execute();

            signal.await();
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }
}