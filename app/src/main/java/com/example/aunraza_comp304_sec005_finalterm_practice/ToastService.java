package com.example.aunraza_comp304_sec005_finalterm_practice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ToastService extends Service {
    static final String TAG = "TOAST_SERVICE";

    public ToastService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String company = intent.getStringExtra("COMPANY_NAME");
        String price = intent.getStringExtra("PRICE");

        Toast.makeText(this, company + ": " + price, Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}