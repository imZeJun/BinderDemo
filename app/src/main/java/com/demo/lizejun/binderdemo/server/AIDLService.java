package com.demo.lizejun.binderdemo.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.demo.lizejun.binderdemoclient.AIDLInterface;

public class AIDLService extends Service {

    private final AIDLInterface.Stub mBinder = new AIDLInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.d("basicTypes", "basicTypes");
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
