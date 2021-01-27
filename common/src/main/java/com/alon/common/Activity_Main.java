package com.alon.common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alon.common.controllers.GarageController;
import com.alon.common.controllers.UsageInfoHelper;
import com.alon.common.models.Garage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Activity_Main extends AppCompatActivity {

    private TextView main_LBL_time, main_LBL_name, main_LBL_address, main_LBL_open, main_LBL_cars;
    private ProgressBar main_PGB_garage;
    private long start, end, usageTime;
    private String startTime, endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        Log.d("pttt", "onCreate");
        findAll();
        UsageInfoHelper.initHelper(this);
        GarageController garageController = new GarageController();
        garageController.start(new GarageController.Callback_Garage() {
            @Override
            public void garage(Garage garage) {
                main_PGB_garage.setVisibility(View.GONE);
                main_LBL_name.setText("Name: " + garage.getName());
                main_LBL_address.setText("Address: " + garage.getAddress());
                String open = garage.isOpen() ? "Yes" : "No";
                main_LBL_open.setText("Open: " + open);
                String cars = "";
                for (int i = 0; i < garage.getCars().length; i++) {
                    cars += (garage.getCars())[i];
                    if (i != garage.getCars().length - 1) {
                        cars += ", ";
                    }
                }
                main_LBL_cars.setText("Cars: " + cars);
            }
        });
    }

    // Function that finds all the views by id.
    private void findAll() {
        main_LBL_time = findViewById(R.id.main_LBL_time);
        main_LBL_name = findViewById(R.id.main_LBL_name);
        main_LBL_address = findViewById(R.id.main_LBL_address);
        main_LBL_open = findViewById(R.id.main_LBL_open);
        main_LBL_cars = findViewById(R.id.main_LBL_cars);
        main_PGB_garage = findViewById(R.id.main_PGB_garage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("pttt", "onResume");
        UsageInfoHelper.getInstance().getAllUsageInfo(new UsageInfoHelper.Callback_UsageInfo() {
            @Override
            public void dataReady(String usageTime) {
                main_LBL_time.setText(usageTime);
            }
        });
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        startTime = dateFormat.format(date);
        start = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pttt", "onPause");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        endTime = dateFormat.format(date);
        end = System.currentTimeMillis();
        usageTime = end - start;
        UsageInfoHelper.getInstance().addUsageInfo(startTime, endTime, usageTime);
    }
}