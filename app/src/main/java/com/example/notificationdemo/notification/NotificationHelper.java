package com.example.notificationdemo.notification;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import static android.content.Context.ALARM_SERVICE;

public class NotificationHelper {
    public static int ALARM_TYPE_RTC = 100;
    private static AlarmManager alarmManager;
    private static PendingIntent alarmIntent;

    public static void scheduleRepeatNotification(Context context) {
        //Setting intent to class where notification will be handled
        Intent intent = new Intent(context, AlarmReceiver.class);
        //Setting pending intent to respond to broadcast sent by AlarmManager everyday at 5 minutes
        alarmIntent = PendingIntent.getBroadcast(context, ALARM_TYPE_RTC, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //getting instance of AlarmManager service
        alarmManager = (AlarmManager)context.getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5 * 60 * 1000, alarmIntent);
    }

    public static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
