package com.alon.multiappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alon.common.Activity_Main;

public class MainActivity extends Activity_Main {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setTitle("Manager");
    }
}