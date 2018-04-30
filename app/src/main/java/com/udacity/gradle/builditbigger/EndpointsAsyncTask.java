package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

// TODO 37 ) Creating EndpointsAsyncTask to retrieve jokes via AsyncTask
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    // TODO 38 ) Defining MyApi and EndpointsTaskListener
    private static MyApi myApiService = null;
    private EndpointsTaskListener mListener = null;

    // TODO 58 ) Defining empty constructor
    public EndpointsAsyncTask(){

    }

    // TODO 54 ) Defining a constructor to set listener
    public EndpointsAsyncTask(EndpointsTaskListener endpointsTaskListener) {
        mListener = endpointsTaskListener;
    }


    // TODO 39 ) Creating EndpointsTaskListener interface to check whether jokes are displayed or not via onComplete
    public static interface EndpointsTaskListener {
        public void onComplete(String joke);
    }

    // TODO 40 ) Implementing Google Client Request Initializer in doInBackground
    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.3.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8888/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        // TODO 41 ) Executing sayJoke to get jokes from CreatingJoke from providejokes module
        try {
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    // TODO 42 ) Checking whether joke is listed by opening an Intent or not.
    @Override
    protected void onPostExecute(String s) {
        this.mListener.onComplete(s);
    }


    // TODO 47 ) Setting EndpointsTaskListener and Returning it
    public EndpointsAsyncTask setListener(EndpointsTaskListener listener) {
        this.mListener = listener;
        return this;
    }
}



