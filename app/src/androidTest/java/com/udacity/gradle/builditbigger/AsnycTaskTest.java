package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

// TODO 54 ) Adding Functional Tests as defined AsnycTaskTest
@RunWith(AndroidJUnit4.class)
public class AsnycTaskTest {

    // TODO 55 ) Defining jokeTestTask as a String
    String jokeTestTask = null;

    // TODO 58 ) Defining result as a String
    String result = null;

    // TODO 56 ) Defining testEndpointsTask method
    @Test
    public void testEndpointAsyncTask(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.setListener(new EndpointsAsyncTask.EndpointsTaskListener() {
            @Override
            public void onComplete(String joke) {
                jokeTestTask = joke;
            }
        }).execute();


        try {
            result = endpointsAsyncTask.get();
            Log.d("AsnycTaskTest", "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO 57 ) Successfully retrieving a non-empty string
        assertFalse(TextUtils.isEmpty(jokeTestTask));

        // TODO 59 ) Successfully retrieving a non-empty string as a Result
        assertNotNull(result);
    }
}
