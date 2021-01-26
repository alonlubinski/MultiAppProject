package com.alon.common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public abstract class Activity_Main extends AppCompatActivity {

    private TextView main_LBL_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        main_LBL_title = findViewById(R.id.main_LBL_title);
    }

    protected void setTitle(String title){
        main_LBL_title.setText(title);
    }
}