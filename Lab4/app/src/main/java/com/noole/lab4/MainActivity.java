package com.noole.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver callReceiver;
    private List<String> callList = new ArrayList<>();
    //private ArrayAdapter<String> adapter;
    CallAdapter callAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callReceiver = new CallReciver(this);
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(callReceiver,filter);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,callList);
        //ListView numbersList = findViewById(R.id.numbers_listview);
        //numbersList.setAdapter(adapter);
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        callAdapter = new CallAdapter(this,callList);
        recyclerView.setAdapter(callAdapter);

    }

    //lisab telefoni numberi nimekirja
    public void addPhoneNumberToList(String number){
        callList.add(number);
        //adapter.notifyDataSetChanged();
        callAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(callReceiver);
    }
}













