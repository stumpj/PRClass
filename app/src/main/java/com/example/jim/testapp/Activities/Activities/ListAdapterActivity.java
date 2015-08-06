package com.example.jim.testapp.Activities.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jim.testapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAdapterActivity extends AppCompatActivity {

    List<Student> mStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter);

        mStudents = new ArrayList<>();

        mStudents.add(new Student("Bob", "123543"));
        mStudents.add(new Student("Al", "Ab45654"));
        mStudents.add(new Student("Fred", "023543"));
        mStudents.add(new Student("Ted", "34625"));

        ListView lv = (ListView) findViewById(R.id.list_adapter_listview);

        BaseAdapter adp = new MyAdapter();

        lv.setAdapter(adp);

        adp.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student s = (Student) parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), s.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public void notifyDataSetChanged() {
            Collections.sort(mStudents);

            super.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mStudents.size();
        }

        @Override
        public Student getItem(int position) {
            return mStudents.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_row_myrow, parent, false);
            }

            TextView name = (TextView) convertView.findViewById(R.id.list_adapter_listview_sName);
            TextView id = (TextView) convertView.findViewById(R.id.list_adapter_listview_sIs);

            name.setText(mStudents.get(position).mName);
            id.setText(mStudents.get(position).mId);

            return convertView;
        }
    }


    private class Student implements Comparable<Student> {
        private String mName;
        private String mId;

        public Student(String name, String id) {
            mName = name;
            mId = id;
        }

        public String toString() {
            return mName + ": " + mId;
        }

        @Override
        public int compareTo(Student another) {
            return mName.compareTo(another.mName);
        }
    }
}
