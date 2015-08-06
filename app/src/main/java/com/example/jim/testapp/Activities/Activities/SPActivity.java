package com.example.jim.testapp.Activities.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.jim.testapp.R;

public class SPActivity extends AppCompatActivity {

    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        mTxt = (TextView) findViewById(R.id.spactivity_txt);


        SharedPreferences sp = this.getSharedPreferences(getString(R.string.spFile_mySP),
                Context.MODE_PRIVATE);
        String myText = sp.getString(getString(R.string.spFile_mySP_mystring), "No value");
        mTxt.setText(myText);


    }

}
