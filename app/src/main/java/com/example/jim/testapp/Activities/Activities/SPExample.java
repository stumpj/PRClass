package com.example.jim.testapp.Activities.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jim.testapp.R;

public class SPExample extends AppCompatActivity {

    private EditText mETxt;
    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample);

        mTxt = (TextView) findViewById(R.id.spexample_txt_maintext);
        mETxt = (EditText) findViewById(R.id.spexample_etxt);

        SharedPreferences sp = this.getSharedPreferences(getString(R.string.spFile_mySP),
                Context.MODE_PRIVATE);

        String myText = sp.getString(getString(R.string.spFile_mySP_mystring), "No value");
        mTxt.setText(myText);
    }


    public void submit(View v) {
        SharedPreferences sp = this.getSharedPreferences(getString(R.string.spFile_mySP),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor spE = sp.edit();
        spE.putString(getString(R.string.spFile_mySP_mystring), mETxt.getText().toString());
        spE.commit();


        mTxt.setText(mETxt.getText().toString());
    }

    public void nextActivity(View v) {
        startActivity(new Intent(this, SPActivity.class));
    }

    public void clearSP(View v) {
        SharedPreferences sp = this.getSharedPreferences(getString(R.string.spFile_mySP),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor spE = sp.edit();
        spE.clear();
        spE.commit();
    }
}