package com.unicartagena.notificaciones;



import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Juan Benitez on 13/10/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String mensaje = remoteMessage.getData().get("message");
        ShowNotification(mensaje);


    }

    private void ShowNotification(String mensaje) {

        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = (Builder) new Builder(this).setAutoCancel(true).setContentTitle("Titulo")
                .setContentText(mensaje)
                .setSmallIcon(R.mipmap.ic_videogame_asset_white_48dp).setContentIntent(pendingIntent);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());


    }
}
