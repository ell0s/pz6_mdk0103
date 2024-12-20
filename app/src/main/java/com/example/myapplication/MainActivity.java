package com.example.myapplication;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnMorning, btnDay, btnEvening, btnNight;
    private ImageView imageMorning, imageDay, imageEvening, imageNight;
    private ConstraintLayout layoutMorning;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID=1;
    private static final String CHANNEL_ID="CHANNEL_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnMorning=(Button) findViewById(R.id.btnMorning);
        btnDay=(Button) findViewById(R.id.btnDay);
        btnEvening=(Button) findViewById(R.id.btnEvening);
        btnNight=(Button) findViewById(R.id.btnNight);
        imageMorning=(ImageView) findViewById(R.id.imageMorning);
        imageDay=(ImageView) findViewById(R.id.imageDay);
        imageEvening=(ImageView) findViewById(R.id.imageEvening);
        imageNight=(ImageView) findViewById(R.id.imageNight);
        layoutMorning=(ConstraintLayout) findViewById(R.id.layoutMorning);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void btnMorningClick(View view){
        layoutMorning.setVisibility(View.VISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.INVISIBLE);

        notificationManager=(NotificationManager) getApplicationContext().getSystemService((Context.NOTIFICATION_SERVICE));
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.drawable.sun)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Утро")
                        .setContentText("Пора раздупляться")
                        .setPriority(PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
    }
    public void btnDayClick(View view){
        layoutMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.VISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.INVISIBLE);

        notificationManager=(NotificationManager) getApplicationContext().getSystemService((Context.NOTIFICATION_SERVICE));
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.drawable.sun)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("День")
                        .setContentText("Пора кушать")
                        .setPriority(PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
    }

    private void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID, CHANNEL_ID,NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    public void btnEveningClick(View view){
        layoutMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.VISIBLE);
        imageNight.setVisibility(View.INVISIBLE);

        notificationManager=(NotificationManager) getApplicationContext().getSystemService((Context.NOTIFICATION_SERVICE));
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.drawable.sun)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Вечер")
                        .setContentText("Пора отдохнуть")
                        .setPriority(PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
    }
    public void btnNightClick(View view){
        layoutMorning.setVisibility(View.INVISIBLE);
        imageDay.setVisibility(View.INVISIBLE);
        imageEvening.setVisibility(View.INVISIBLE);
        imageNight.setVisibility(View.VISIBLE);

        notificationManager=(NotificationManager) getApplicationContext().getSystemService((Context.NOTIFICATION_SERVICE));
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.drawable.sun)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Ночь")
                        .setContentText("Пора баиньки")
                        .setPriority(PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
    }
}