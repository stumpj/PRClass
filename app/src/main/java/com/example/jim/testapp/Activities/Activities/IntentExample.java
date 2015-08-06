package com.example.jim.testapp.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.jim.testapp.R;

public class IntentExample extends AppCompatActivity {

    //constant for the tag (or key) for data passed via intent
    public static final String INTENT_TAG_MAIN_TEXT = "etxttext";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example);
    }

    //one way to add onClick handling
    public void xmlClick(View v) {
        EditText etxt = (EditText) findViewById(R.id.intent_etxt);
        //
        String mytxt = etxt.getText().toString();

        Intent i = new Intent(this, AnotherActivity.class);
        i.putExtra(INTENT_TAG_MAIN_TEXT, mytxt);
        startActivity(i);
    }

    //alternate way to create onClick handling
    //then, on the button, setOnClickListener(new MyButtonClick);
    private class MyButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.i("Main", "Button Click");
        }
    }
}
