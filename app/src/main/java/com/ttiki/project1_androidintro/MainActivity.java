package com.ttiki.project1_androidintro;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.renderscript.ScriptGroup;
import android.widget.Button;

import com.google.android.filament.View;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRAMESSAGE_NAME = "com.ttiki.activiti1.MESSAGE_NAME";
    public static final String EXTRAMESSAGE_SURNAME = "com.ttiki.activiti1.MESSAGE_SURNAME";
    
    Button btnSec, btnThird;
    TextInputLayout nameInput, surnameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrieve inputs
        nameInput = (TextInputLayout)findViewById(R.id.nameInputText);
        surnameInput = (TextInputLayout)findViewById(R.id.surnameInputText);

        //Retrieve buttons
        btnSec = (Button)findViewById(R.id.second_btn);
        btnThird = (Button)findViewById(R.id.third_btn);

        //Second button click event
        //Switch to the second view!
        btnSec.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(MainActivity.this,
                        SecondPage.class);
                //We send the name
                i.putExtra(EXTRAMESSAGE_NAME, nameInput.getEditText().toString());
                //We send the surname
                i.putExtra(EXTRAMESSAGE_SURNAME, surnameInput.getEditText().toString());
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