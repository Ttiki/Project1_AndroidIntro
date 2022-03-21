package com.ttiki.project1_androidintro;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {

    Button btnSec, btnThird;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSec = (Button)findViewById(R.id.second_btn);
        btnThird = (Button)findViewById(R.id.third_btn);

            //Second button click event
            //Switch to the second view!
            btnSec.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Intent i = new Intent(MainActivity.this,
                            SecondPage.class);
                    startActivity(i);
                }
            });

        //Third button click event
        //Switch to the third view!
        btnThird.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(MainActivity.this,
                        ThirdPage.class);
                startActivity(i);
            }
        });
    }


}