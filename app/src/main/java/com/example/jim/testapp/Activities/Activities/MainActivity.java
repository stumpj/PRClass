package com.example.jim.testapp.Activities.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jim.testapp.R;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_TEXT = "etxttext";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    public void xmlClick(View v) {
        EditText etxt = (EditText) findViewById(R.id.main_etxt);
        String mytxt = etxt.getText().toString();

        Intent i = new Intent(this, AnotherActivity.class);
        i.putExtra(MAIN_TEXT, mytxt);
        startActivity(i);
    }

    private class MyButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Log.i("Main", "Button Click");
        }
    }
}
