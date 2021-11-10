package com.example.needforspeedafeka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

import Models.CarView;

public class MainActivity extends AppCompatActivity {

    private CarView carView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carView = new CarView(this);
        setContentView(carView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        carView.invalidate();
                    }
                });
            }
        },0,Interval);


    }
}