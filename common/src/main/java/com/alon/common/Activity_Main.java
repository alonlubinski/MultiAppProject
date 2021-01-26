package com.alon.common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public abstract class Activity_Main extends AppCompatActivity {

    private TextView main_LBL_name, main_LBL_address, main_LBL_open, main_LBL_cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        findAll();
        GarageController garageController = new GarageController();
        garageController.start(new GarageController.Callback_Garage() {
            @Override
            public void garage(Garage garage) {
                main_LBL_name.setText("Name: " + garage.getName());
                main_LBL_address.setText("Address: " + garage.getAddress());
                main_LBL_open.setText("Open: " + Boolean.valueOf(garage.isOpen()).toString());
                String cars = "";
                for(int i = 0; i < garage.getCars().length; i++){
                    cars += (garage.getCars())[i];
                    if(i != garage.getCars().length - 1){
                        cars += ", ";
                    }
                }
                main_LBL_cars.setText("Cars: " + cars);
            }
        });
    }

    private void findAll() {
        main_LBL_name = findViewById(R.id.main_LBL_name);
        main_LBL_address = findViewById(R.id.main_LBL_address);
        main_LBL_open = findViewById(R.id.main_LBL_open);
        main_LBL_cars = findViewById(R.id.main_LBL_cars);
    }

}