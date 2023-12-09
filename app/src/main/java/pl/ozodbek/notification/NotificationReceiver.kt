import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import pl.ozodbek.notification.MainActivity
import pl.ozodbek.notification.R

class NotificationReceiver : BroadcastReceiver() {
    private val channel_id = "My_app_channel"

    override fun onReceive(context: Context, intent: Intent) {
        val appIcon = BitmapFactory.decodeResource(context.resources, R.drawable.img)
        val notificationIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context, channel_id)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Happy Birthday !!")
            .setContentText("Have a good day !!")
            .setLargeIcon(appIcon)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.img, "Open app", pendingIntent)
            .addAction(R.drawable.img, "Close app", pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("This is an example of a notification with big text. " +
                        "It can be used to display a longer message that may not fit " +
                        "in the normal content text field.")
                .setBigContentTitle("Example")
                .setSummaryText("knskcnksnkc@gmail.com")
            )

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, builder.build())
    }
}
