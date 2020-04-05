package com.dheeptha.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.dheeptha.notification.R.string.channel_name;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "455677889" ;
    Button Login;
    NotificationCompat.Builder builder;
    NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        Login = findViewById(R.id.button_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoggedInNotificatoin();
            }
        });





    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notification Title";
            String description = "Notification Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Welcome Your name")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager = NotificationManagerCompat.from(this);
    }

    private void showLoggedInNotificatoin(){
        notificationManager.notify(616269, builder.build());
    }
}
