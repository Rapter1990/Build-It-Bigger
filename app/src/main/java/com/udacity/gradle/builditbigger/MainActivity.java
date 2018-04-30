package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import company.example.android.displayjoke.ShowJokeActivity;

// TODO 43 ) Implementing EndpointsTaskListener of EndpointsAsyncTask
public class MainActivity extends AppCompatActivity
        implements EndpointsAsyncTask.EndpointsTaskListener{

    // TODO 44 ) Defining the attributes(joke text,joke button and progress bar) of fragment_main.xml via ButterKnife
    @BindView(R.id.joke_text_view)
    TextView jokeTextView;

    @BindView(R.id.joke_button)
    Button jokeButton;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 53 ) Implementing ButterKnife
        ButterKnife.bind(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // TODO 48 ) Telling Joke via EndpointsAsyncTask
    public void tellJoke(View view) {

        EndpointsAsyncTask task = new EndpointsAsyncTask(this);
        //task.setListener(this);
        task.execute();

        // TODO 51 ) Showing Progress Bar
        showProgress();
    }


    @Override
    public void onComplete(String joke) {

        // TODO 52 ) Calling displayJoke with sending joke as a String
        displayJoke(joke);
    }


    // TODO 45 ) Showing Progress Bar
    private void showProgress() {
        jokeTextView.setVisibility(View.INVISIBLE);
        jokeButton.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    // TODO 46 ) Hiding Progress Bar
    private void hideProgress() {
        jokeTextView.setVisibility(View.VISIBLE);
        jokeButton.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    // TODO 49 ) Displaying Joke by opening a new Intent with its key value
    private void displayJoke(String joke) {
        Log.d("EndpointsAsyncTask", "joke is: " + joke);
        Intent displayJokeActivityIntent =
                new Intent(MainActivity.this, ShowJokeActivity.class);
        Bundle extras = new Bundle();
        extras.putString("jokeDisplay", joke);
        displayJokeActivityIntent.putExtras(extras);

        // TODO 50 ) Hiding Progress Bar
        hideProgress();
        startActivity(displayJokeActivityIntent);
    }

}
