package com.thedeveloperworldisyours.cloudstorage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.thedeveloperworldisyours.cloudstorage.utils.CloudStorage;
import com.thedeveloperworldisyours.cloudstorage.utils.Work;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void uploadClick(View view) {
        Message message = new Message();
        message.what = Work.UPLOAD_FILE;
        handler.sendMessage(message);
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Work.UPLOAD_FILE:
                    upload();
                    break;

            }
        }
    };

    public void upload() {
        try {
            CloudStorage.uploadFile("bucket-xxx", "photo.jpg");

        } catch (Exception e) {
            Log.d(TAG, "Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
