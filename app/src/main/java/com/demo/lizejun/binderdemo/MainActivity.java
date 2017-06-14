package com.demo.lizejun.binderdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ServiceConnection mDemoServiceConnection;
    private DemoService.DemoBinder mDemoBinder;
    private Observer mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Intent intent = new Intent(this, DemoService.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent(this, DemoService.class);
        stopService(intent);
    }

    public void bind(View view) {
        if (mDemoServiceConnection == null) {
            mDemoServiceConnection = new DemoServiceConnection();
            Intent intent = new Intent(this, DemoService.class);
            bindService(intent, mDemoServiceConnection, BIND_AUTO_CREATE);
        }
    }

    public void unbind(View view) {
        if (mDemoServiceConnection != null) {
            unbindService(mDemoServiceConnection);
            mDemoServiceConnection = null;
        }
    }

    public void invokeService(View view) {
        if (mDemoBinder != null) {
            mDemoBinder.getResult();
        }
    }

    private class DemoServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            mDemoBinder = (DemoService.DemoBinder) service;
            mObserver = new DemoObserver();
            mDemoBinder.addObserver(mObserver);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //只有当意外销毁时才会被调用。
            mDemoBinder = null;
        }
    }

    private class DemoObserver implements Observer {

        @Override
        public void onResult(String result) {
            Log.d(TAG, "onResult=" + result);
        }
    }

}
