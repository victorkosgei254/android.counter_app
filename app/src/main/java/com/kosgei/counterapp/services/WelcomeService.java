package com.kosgei.counterapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class WelcomeService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SERVICE", "onStartCommand: ");
        Toast.makeText(this,"Service has started",Toast.LENGTH_LONG).show();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.d("SERVICE", "onDestroy: ");
        super.onDestroy();
        Toast.makeText(this,"This service is destroyed",Toast.LENGTH_SHORT).show();
    }
}
