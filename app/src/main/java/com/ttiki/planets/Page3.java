package com.ttiki.planets;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ttiki.planets.databinding.ActivityPage3Binding;

public class Page3 extends AppCompatActivity {
    ActivityPage3Binding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityPage3Binding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
    }
}