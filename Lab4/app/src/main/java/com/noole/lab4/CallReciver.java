package com.noole.lab4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReciver extends BroadcastReceiver {
    private  static final  String TAG = "CallReceiver";

    MainActivity mainActivity;

    public CallReciver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, intent.getAction());
        String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.i(TAG,"State: " + phoneState + "Number: " + phoneNumber);
        if (phoneNumber != null){
            mainActivity.addPhoneNumberToList(phoneNumber);
        }

    }
}
