package com.demo.lizejun.binderdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class DemoService extends Service {

    private static final String TAG = DemoService.class.getSimpleName();

    public DemoService() {
        Log.d(TAG, "DemoService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return new DemoBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    public static class DemoBinder extends Binder {

        private Observer mObserver;

        public void addObserver(Observer observer) {
            mObserver = observer;
        }

        public void getResult() {
            if (mObserver != null) {
                mObserver.onResult("result");
            }
        }
    }
}
