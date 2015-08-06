package com.example.jim.testapp.Activities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jim.testapp.R;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        // Get the intent created by the parent activity
        Intent i = getIntent();
        String txt = i.getStringExtra(IntentExample.INTENT_TAG_MAIN_TEXT);

        //make sure data was pulled from the intent
        if (txt != null) {
            //update the textview with the text passed via the intent
            TextView mytxt = (TextView) findViewById(R.id.another_txt_main);
            mytxt.setText(txt);
        }


    }

}
