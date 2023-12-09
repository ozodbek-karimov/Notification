package pl.ozodbek.notification

import NotificationReceiver
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.NotificationCompat
import pl.ozodbek.notification.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val channel_id = "My_app_channel"

    private val messages = arrayOf(
        "This is 1",
        "This is 2",
        "This is 3",
        "This is 4",
        "This is 5",
        "This is 6"
    )
    var random = 0
    var incrId = 0

    val max = 100
    var min = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.button.setOnClickListener {
//            setupAlarmAndSendNotification()
//            downloadNotification()
            newNotifications()
        }


        return binding.root
    }

    private fun newNotifications() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val appIcon = BitmapFactory.decodeResource(resources, R.drawable.img)
            val notificationChannel = NotificationChannel(channel_id, "My App Channel", importance)
            notificationChannel.description = "This is my app channel"

            val builder = Notification.Builder(requireContext(), channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Happy Birthday !!")
                .setContentText(messages[random])
                .setLargeIcon(appIcon)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setStyle(
                    Notification.BigTextStyle()
                        .bigText(
                            "This is an example of a notification with big text. " +
                                    "It can be used to display a longer message that may not fit " +
                                    "in the normal content text field."
                        )
                        .setBigContentTitle("Example")
                        .setSummaryText("knskcnksnkc@gmail.com")
                )

            val notificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(++incrId, builder.build())

        } else {

            val builder = NotificationCompat.Builder(requireContext())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Happy Birthday !!")
                .setContentText("Have a good day !!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val notificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(++incrId, builder.build())
        }
    }

//    private fun downloadNotification() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            val appIcon = BitmapFactory.decodeResource(resources, R.drawable.img)
//
//            val notificationChannel =
//                NotificationChannel(channel_id, "Hello World", NotificationManager.IMPORTANCE_HIGH)
//            notificationChannel.description = "This is my app channel"
//
//            val group1 = NotificationChannelGroup("group1", "Group 1")
//            val channel1 =
//                NotificationChannel("channel1", "Channel 1", NotificationManager.IMPORTANCE_HIGH)
//            val channel2 =
//                NotificationChannel("channel2", "Channel 2", NotificationManager.IMPORTANCE_LOW)
//            channel1.group = "group1"
//            channel2.group = "group1"
//
//            val group2 = NotificationChannelGroup("group2", "Group 2")
//            val channel3 =
//                NotificationChannel("channel3", "Channel 3", NotificationManager.IMPORTANCE_HIGH)
//            val channel4 =
//                NotificationChannel("channel4", "Channel 4", NotificationManager.IMPORTANCE_LOW)
//            channel3.group = "group2"
//            channel4.group = "group2"
//
//            val group3 = NotificationChannelGroup("group3", "Group 3")
//            val channel5 =
//                NotificationChannel("channel5", "Channel 5", NotificationManager.IMPORTANCE_HIGH)
//            val channel6 =
//                NotificationChannel("channel6", "Channel 6", NotificationManager.IMPORTANCE_LOW)
//            channel5.group = "group3"
//            channel6.group = "group3"
//
//
//            val notificationIntent = Intent(requireContext(), NotificationReceiver::class.java)
//            val pendingIntent =
//                PendingIntent.getBroadcast(requireContext(), 0, notificationIntent, 0)
//
//            val builder = NotificationCompat.Builder(requireContext(), channel_id)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Downloading Music")
//                .setLargeIcon(appIcon)
//                .setShowWhen(true)
//                .setStyle(NotificationCompat.BigPictureStyle()
//                    .bigPicture(appIcon)
//                    .bigLargeIcon(null)
//                )
//                .setProgress(max, min, true) // set progress bar with 0 progress and 100 as maximum
//                .setContentIntent(pendingIntent)
//                .setPriority(Notification.PRIORITY_DEFAULT)
//
//            val notificationManager =
//                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//            // Update progress bar with an increment in a loop or a separate thread
//            Thread {
//                for (min in 0..100 step 10) {
//                    Thread.sleep(1000) // wait for a second before updating the progress again
//                    builder.setProgress(max, min, false) // update progress bar with new progress
//                        .setContentText("$min")
//                    notificationManager.notify(0, builder.build()) // update the notification
//                }
//            }.start()
//
//            // remove progress bar and update notification with completion message
//            builder.setProgress(0, 0, false) // remove progress bar
//                .setContentTitle("Download Complete")
//                .setContentText("Music has been downloaded successfully")
//
//            notificationManager.createNotificationChannel(notificationChannel)
//            notificationManager.notify(0, builder.build())
//
//            notificationManager.notify(0, builder.build())
//            notificationManager.createNotificationChannelGroup(group1)
//            notificationManager.createNotificationChannel(channel1)
//            notificationManager.createNotificationChannel(channel2)
//            notificationManager.createNotificationChannelGroup(group2)
//            notificationManager.createNotificationChannel(channel3)
//            notificationManager.createNotificationChannel(channel4)
//            notificationManager.createNotificationChannelGroup(group3)
//            notificationManager.createNotificationChannel(channel5)
//            notificationManager.createNotificationChannel(channel6)
//
//
//        } else {
//
//            val builder = NotificationCompat.Builder(requireContext())
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Happy Birthday !!")
//                .setContentText("Have a good day !!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//            val notificationManager =
//                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.notify(0, builder.build())
//        }
//    }




//    private fun setupAlarmAndSendNotification() {
//        random = (messages.indices).random()
//
//
//        val notificationIntent = Intent(requireContext(), NotificationReceiver::class.java)
//        val pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, notificationIntent, 0)
////        val interval = 30 * 1000 // 30 seconds
////        val alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val importance = NotificationManager.IMPORTANCE_HIGH
//            val appIcon = BitmapFactory.decodeResource(resources, R.drawable.img)
//            val notificationChannel = NotificationChannel(channel_id, "My App Channel", importance)
//            notificationChannel.description = "This is my app channel"
//
////            alarmManager.setRepeating(
////                AlarmManager.RTC_WAKEUP,
////                System.currentTimeMillis() + interval,
////                interval.toLong(),
////                pendingIntent
////            )
//
//            val builder = Notification.Builder(requireContext(), channel_id)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Happy Birthday !!")
//                .setContentText(messages[random])
//                .setLargeIcon(appIcon)
//                .setContentIntent(pendingIntent)
//                .addAction(R.drawable.img, "Open app", pendingIntent)
//                .addAction(R.drawable.img, "Close app", pendingIntent)
//                .setPriority(Notification.PRIORITY_DEFAULT)
//                .setStyle(
//                    Notification.BigTextStyle()
//                        .bigText(
//                            "This is an example of a notification with big text. " +
//                                    "It can be used to display a longer message that may not fit " +
//                                    "in the normal content text field."
//                        )
//                        .setBigContentTitle("Example")
//                        .setSummaryText("knskcnksnkc@gmail.com")
//                )
//
//            val notificationManager =
//                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(notificationChannel)
//            notificationManager.notify(++incrId, builder.build())
//
//        } else {
////            alarmManager.setRepeating(
////                AlarmManager.RTC_WAKEUP,
////                System.currentTimeMillis() + interval,
////                interval.toLong(),
////                pendingIntent
////            )
//
//            val builder = NotificationCompat.Builder(requireContext())
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Happy Birthday !!")
//                .setContentText("Have a good day !!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//            val notificationManager =
//                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.notify(++incrId, builder.build())
//        }
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
