package com.example.bcr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button send;
    Button createNew;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.button);
        createNew = findViewById(R.id.createNewActivity);
        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                click();
            }
        });
        createNew.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createNewActivity();
            }
        });
    }

    public void click() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent();
                intent1.putExtra("args", "{\"activity_id\":\"2c422b84-c8e7-4bef-adbf-4b5c37caf62d\",\"user_id\":\"78910\" ,\"start_datetime\":\"2019-12-12 08:00\",\"end_datetime\":\"2019-12-12 08:00\"}");
                intent1.setAction("com.btpns.android.dam.finishactivity");
                sendBroadcast(intent1);
            }
        }, 10000L);
    }

    public void createNewActivity() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent();
                intent1.putExtra("args", "{\"start_datetime\":\"2019-12-12 08:00\",\"end_datetime\":\"2019-12-12 08:00\",\"description\":\"PM description\",\"title\":\"PM Test\",\"type\":\"PM\",\"owner_id\":\"78910\",\"user_id\":\"78910\"}");
                intent1.setAction("com.btpns.android.dam.createactivity");
                sendBroadcast(intent1);
            }
        }, 10000L);
    }
}
