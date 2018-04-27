package company.example.android.displayjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;


// TODO 21 ) Creating displayjoke module as a android library to display a joke passed to it as an intent extra
// TODO 22 ) Creating ShowJokeActivity to display joke
public class ShowJokeActivity extends AppCompatActivity {

    // TODO 23 ) Defining Joke text as a Texview
    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        // TODO 23 ) Finiding jokeTextView by it id value
        jokeTextView = findViewById(R.id.joke_text);

        // TODO 25 ) Checking whether intent is null or not and it has an extra value or not
        if(getIntent() != null && getIntent().hasExtra("jokeDisplay")){

            // TODO 26 ) Defining Bundle from intent with its extra value
            Bundle jokeBundle = getIntent().getExtras();

            // TODO 27 ) Getting a joke String from Bundle
            String joke = jokeBundle.getString("jokeDisplay");

            // TODO 28 ) Checking whether joke is empty or not
            if(!TextUtils.isEmpty(joke))
            {
                // TODO 29 ) Setting joke in the TextView
                jokeTextView.setText(joke);
            }else{

                // TODO 30 ) Setting joke not found in the TextView
                jokeTextView.setText(R.string.joke_not_found);
            }
        }else{
            // TODO 31 ) Setting empty intent in the TextView
            jokeTextView.setText(R.string.intent_empty);
        }
    }
}
