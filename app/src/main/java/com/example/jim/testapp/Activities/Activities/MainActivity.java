package com.example.jim.testapp.Activities.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.jim.testapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtons();
    }

    private void addButtons() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.main_layout);

        ll.addView(new Lesson("List View/Adapter", ListAdapterActivity.class));
        ll.addView(new Lesson("Shared Preferences", SPExample.class));
        ll.addView(new Lesson("Intents", IntentExample.class));
    }

    private class Lesson extends Button {

        public Lesson(String title, Class target) {
            super(getBaseContext());
            setText(title);
            setOnClickListener(new Clicks(target));
        }
    }

    private class Clicks implements View.OnClickListener {
        private final Intent mIntent;

        public Clicks(Class target) {
            mIntent = new Intent(getBaseContext(), target);
        }

        @Override
        public void onClick(View v) {
            startActivity(mIntent);
        }
    }
}
