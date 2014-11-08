package com.example.untitled1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.Date;

/**
 * Created by artem on 08.11.14.
 */
public class BackgroundTask extends Service implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometerSensor;
    private Float position = 0f;
    private long time = 0l;

    public static MediaPlayer mediaPlayer;

    public void onCreate() {
        super.onCreate();
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        for (Sensor sensor : mSensorManager.getSensorList(Sensor.TYPE_ALL)) {
            if(sensor.getType() == Sensor.TYPE_ACCELEROMETER && mAccelerometerSensor == null){
                mAccelerometerSensor = sensor;
            }
        }
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSensorManager.registerListener(this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
        return super.onStartCommand(intent, flags, startId);

    }

    public void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            boolean flag = sensorEvent.values[0] > position + 5 || sensorEvent.values[0] < position - 5;
            flag = flag && new Date().getTime() - time > 3000;
            if (mediaPlayer != null && !mediaPlayer.isPlaying() && flag ) {
                position = sensorEvent.values[0];
                time = new Date().getTime();
                mediaPlayer.start();
            }
        } catch (Throwable t) {
            System.out.print(t);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
