package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

// TODO 54 ) Adding Functional Tests as defined AsnycTaskTest
public class AsnycTaskTest extends ApplicationTestCase {

    // TODO 55 ) Defning jokeTestTask as a String
    String jokeTestTask = null;

    // TODO 56 ) Implementing constructor as AsnycTaskTest
    public AsnycTaskTest() {
        super(Application.class);
    }

    // TODO 57 ) Defining testEndpointsTask method
    public void testEndpointAsyncTask(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.setListener(new EndpointsAsyncTask.EndpointsTaskListener() {
            @Override
            public void onComplete(String joke) {
                jokeTestTask = joke;
            }
        }).execute();

        // TODO 58 ) Successfully retrieving a non-empty string
        assertFalse(TextUtils.isEmpty(jokeTestTask));
    }
}
