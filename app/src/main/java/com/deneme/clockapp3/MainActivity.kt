package com.deneme.clockapp3

import android.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val alarmFragment = AlarmFragment()
    private val stopwatchFragment = StopwatchFragment()
    private val countdownFragment = CountdownFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(alarmFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_alarm -> replaceFragment(alarmFragment)
                R.id.ic_stopwatch -> replaceFragment(stopwatchFragment)
                R.id.ic_countdown -> replaceFragment(countdownFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

}