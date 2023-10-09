package com.example.sensordataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor sensorLight;
    private Sensor sensorProximity;
    private SensorManager sensorManager;
    private TextView textSensorLight, textSensorProximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSensorLight = (TextView) findViewById(R.id.label_light);
        textSensorProximity = (TextView) findViewById(R.id.label_proximity);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorLight =sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(sensorLight == null)
            textSensorLight.setText("No sensor");
        if(sensorProximity == null)
            textSensorProximity.setText("No sensor");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        switch (sensorType){
            case Sensor.TYPE_LIGHT:
                    textSensorLight.setText("Light Sensor: " + currentValue);
                break;
            case Sensor.TYPE_PROXIMITY:
                    textSensorProximity.setText("Proximity Sensor: " + currentValue);
                    break;
        }
    }
    @Override //    Depending on the types of sensors, these sensor value array means differently. You can take a further look on Android Development resource as below to see more about which values mean on each type of sensor
    public void onAccuracyChanged(Sensor sensor, int accuracy){


    }
    @Override
    protected void onStart(){
        super.onStart();
        if(sensorProximity != null){
            sensorManager.registerListener(this, sensorProximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorLight !=null){
            sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this);
    }

}