package com.example.notificationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.notificationdemo.notification.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    TextView txtBuilVarientType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        txtBuilVarientType=(TextView)findViewById(R.id.txt_buildvarient);
        txtBuilVarientType.setText(BuildConfig.TYPE);
        //getting Notification Every 5 minutes
        NotificationHelper.scheduleRepeatNotification(mContext);
    }
}
