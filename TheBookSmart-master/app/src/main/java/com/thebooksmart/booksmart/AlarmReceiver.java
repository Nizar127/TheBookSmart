package com.thebooksmart.booksmart;

//import android.app.Notification;
/*
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
*/

//to receuve
/*
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Intent notificationIntent = new Intent(context, NotificationActivity.class);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(100, PendingIntent.FLAG_UPDATE_CURRENT);

        //this version is deprecated. Need to find new way
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        Notification notification = builder.setContentTitle("Reminder To Check In");
            .setContentText("Please Check In To Respective Business Within 3 Days");  //add check in button
            .setContentTicker("Check In Time!");
            .setAutoCancel(true);
            .setSmallIcon(R.mipmap.ic_launcher);
            .setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

    }
}
*/
