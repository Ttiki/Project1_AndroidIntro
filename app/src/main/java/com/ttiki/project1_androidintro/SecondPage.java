package com.ttiki.project1_androidintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        //Retrieve intent to retrieve sent information
        Intent i = getIntent();
        String name = i.getStringExtra("EXTRAMESSAGE_NAME");

        TextView tv = (TextView)findViewById(R.id.nameTest);
        tv.setText(name);
    }
}