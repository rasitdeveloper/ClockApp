package com.deneme.clockapp3

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deneme.clockapp3.databinding.FragmentAlarmBinding
import com.deneme.clockapp3.databinding.FragmentStopwatchBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*


class AlarmFragment : Fragment() {

    private var _binding : FragmentAlarmBinding? = null
    private val binding get() = _binding!!

    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlarmBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createNotificationChannel()

        binding.selectTimeBtn1.setOnClickListener {
            showTimePicker1()
        }

        binding.setAlarmBtn1.setOnClickListener {
            setAlarm1()
        }

        binding.cancelAlarmBtn1.setOnClickListener {
            cancelAlarm1()
        }

        binding.selectTimeBtn2.setOnClickListener {
            showTimePicker2()
        }

        binding.setAlarmBtn2.setOnClickListener {
            setAlarm2()
        }

        binding.cancelAlarmBtn2.setOnClickListener {
            cancelAlarm2()
        }

        binding.selectTimeBtn3.setOnClickListener {
            showTimePicker3()
        }

        binding.setAlarmBtn3.setOnClickListener {
            setAlarm3()
        }

        binding.cancelAlarmBtn3.setOnClickListener {
            cancelAlarm3()
        }

        binding.open2.setOnClickListener {
            binding.selectTimeBtn2.visibility = View.VISIBLE
            binding.setAlarmBtn2.visibility = View.VISIBLE
            binding.cancelAlarmBtn2.visibility = View.VISIBLE
            binding.exit2.visibility = View.VISIBLE
            binding.selectedTimeTxt2.visibility = View.VISIBLE
            binding.open3.visibility = View.VISIBLE
        }

        binding.open3.setOnClickListener {
            binding.selectTimeBtn3.visibility = View.VISIBLE
            binding.setAlarmBtn3.visibility = View.VISIBLE
            binding.cancelAlarmBtn3.visibility = View.VISIBLE
            binding.exit3.visibility = View.VISIBLE
            binding.selectedTimeTxt3.visibility = View.VISIBLE
        }

        binding.exit2.setOnClickListener {
            binding.selectTimeBtn2.visibility = View.INVISIBLE
            binding.setAlarmBtn2.visibility = View.INVISIBLE
            binding.cancelAlarmBtn2.visibility = View.INVISIBLE
            binding.selectedTimeTxt2.visibility = View.INVISIBLE
            binding.exit2.visibility = View.INVISIBLE
        }

        binding.exit3.setOnClickListener {
            binding.selectTimeBtn3.visibility = View.INVISIBLE
            binding.setAlarmBtn3.visibility = View.INVISIBLE
            binding.cancelAlarmBtn3.visibility = View.INVISIBLE
            binding.selectedTimeTxt3.visibility = View.INVISIBLE
            binding.exit3.visibility = View.INVISIBLE
            binding.open3.visibility = View.INVISIBLE
        }
    }

    private fun cancelAlarm1() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(getActivity(), "Alam Cancelled", Toast.LENGTH_LONG).show()
    }

    private fun setAlarm1() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
        Toast.makeText(getActivity(), "Alarm set succesfuly", Toast.LENGTH_LONG).show()
    }



    private fun showTimePicker1() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        getActivity()?.let { picker.show(it.supportFragmentManager, "foxandroid") }
        picker.addOnPositiveButtonClickListener {
            binding.selectedTimeTxt1.text = String.format("%02d", picker.hour) + " : " + String.format("%02d", picker.minute)
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }

    private fun cancelAlarm2() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 2, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(getActivity(), "Alam Cancelled", Toast.LENGTH_LONG).show()
    }

    private fun setAlarm2() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 2, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
        Toast.makeText(getActivity(), "Alarm set succesfuly", Toast.LENGTH_LONG).show()
    }



    private fun showTimePicker2() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        getActivity()?.let { picker.show(it.supportFragmentManager, "foxandroid") }
        picker.addOnPositiveButtonClickListener {
            binding.selectedTimeTxt2.text = String.format("%02d", picker.hour) + " : " + String.format("%02d", picker.minute)
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }


    private fun cancelAlarm3() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 3, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(getActivity(), "Alam Cancelled", Toast.LENGTH_LONG).show()
    }

    private fun setAlarm3() {
        alarmManager = getActivity()?.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(getActivity(), AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 3, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
        Toast.makeText(getActivity(), "Alarm set succesfuly", Toast.LENGTH_LONG).show()
    }



    private fun showTimePicker3() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        getActivity()?.let { picker.show(it.supportFragmentManager, "foxandroid") }
        picker.addOnPositiveButtonClickListener {
            binding.selectedTimeTxt3.text = String.format("%02d", picker.hour) + " : " + String.format("%02d", picker.minute)
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name : CharSequence = "foxandroidReminderChannel"
            val description = "Channel for Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("foxandroid", name, importance)
            channel.description = description
            val notificationManager = getActivity()?.getSystemService(
                NotificationManager::class.java
            )

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel)
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}