package com.deneme.clockapp3

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_countdown.*

class CountdownFragment : Fragment() {

    lateinit var countdown_timer1: CountDownTimer
    var isPause1 = false
    var isRunning1 = false
    var second1 = 0L
    var minute1 = 0L
    var hour1 = 0L

    lateinit var countdown_timer2: CountDownTimer
    var isPause2 = false
    var isRunning2 = false
    var second2 = 0L
    var minute2 = 0L
    var hour2 = 0L

    lateinit var countdown_timer3: CountDownTimer
    var isPause3 = false
    var isRunning3 = false
    var second3 = 0L
    var minute3 = 0L
    var hour3 = 0L


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countdown, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plus2.setOnClickListener {
            countDownTimer2.visibility = View.VISIBLE
            hourPlainTxt2.visibility = View.VISIBLE
            minPlainTxt2.visibility = View.VISIBLE
            secPlainTxt2.visibility = View.VISIBLE
            btnstart2.visibility = View.VISIBLE
            btnpause2.visibility = View.VISIBLE
            btnstop2.visibility = View.VISIBLE
            plus3.visibility = View.VISIBLE
            minus2.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView6.visibility = View.VISIBLE
        }

        minus2.setOnClickListener {
            countDownTimer2.visibility = View.INVISIBLE
            hourPlainTxt2.visibility = View.INVISIBLE
            minPlainTxt2.visibility = View.INVISIBLE
            secPlainTxt2.visibility = View.INVISIBLE
            btnstart2.visibility = View.INVISIBLE
            btnpause2.visibility = View.INVISIBLE
            btnstop2.visibility = View.INVISIBLE
            minus2.visibility = View.INVISIBLE
            textView4.visibility = View.INVISIBLE
            textView5.visibility = View.INVISIBLE
            textView6.visibility = View.INVISIBLE
        }

        plus3.setOnClickListener {
            countDownTimer3.visibility = View.VISIBLE
            hourPlainTxt3.visibility = View.VISIBLE
            minPlainTxt3.visibility = View.VISIBLE
            secPlainTxt3.visibility = View.VISIBLE
            btnstart3.visibility = View.VISIBLE
            btnpause3.visibility = View.VISIBLE
            btnstop3.visibility = View.VISIBLE
            plus3.visibility = View.VISIBLE
            minus3.visibility = View.VISIBLE
            view4.visibility = View.VISIBLE
            textView7.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
        }

        minus3.setOnClickListener {
            countDownTimer3.visibility = View.INVISIBLE
            hourPlainTxt3.visibility = View.INVISIBLE
            minPlainTxt3.visibility = View.INVISIBLE
            secPlainTxt3.visibility = View.INVISIBLE
            btnstart3.visibility = View.INVISIBLE
            btnpause3.visibility = View.INVISIBLE
            btnstop3.visibility = View.INVISIBLE
            plus3.visibility = View.INVISIBLE
            minus3.visibility = View.INVISIBLE
            view4.visibility = View.INVISIBLE
            textView7.visibility = View.INVISIBLE
            textView8.visibility = View.INVISIBLE
            textView9.visibility = View.INVISIBLE
        }

        btnstart1.setOnClickListener {
            if (isRunning1 == false) {
                if (getterSecond1() == 0L && getterMinute1() == 0L && getterHour1() == 0L) {
                    Toast.makeText(getActivity(), "Please fill the all blank", Toast.LENGTH_LONG).show()
                } else {
                    start1(getterSecond1(), getterMinute1(), getterHour1())
                    isRunning1 = true
                }
            }
        }

        btnpause1.setOnClickListener {
            countdown_timer1.cancel()
            isPause1 = true
            isRunning1 = false
        }

        btnstop1.setOnClickListener {
            countdown_timer1.cancel()
            secPlainTxt1.setText("0")
            minPlainTxt1.setText("0")
            hourPlainTxt1.setText("0")
            isRunning1 = false
        }


        btnstart2.setOnClickListener {
            if (isRunning2 == false) {
                if (getterSecond2() == 0L && getterMinute2() == 0L && getterHour2() == 0L) {
                    Toast.makeText(getActivity(), "Please fill the all blank", Toast.LENGTH_LONG).show()
                } else {
                    start2(getterSecond2(), getterMinute2(), getterHour2())
                    isRunning2 = true
                }
            }
        }

        btnpause2.setOnClickListener {
            countdown_timer2.cancel()
            isPause2 = true
            isRunning2 = false
        }

        btnstop2.setOnClickListener {
            countdown_timer2.cancel()
            secPlainTxt2.setText("0")
            minPlainTxt2.setText("0")
            hourPlainTxt2.setText("0")
            isRunning2 = false
        }


        btnstart3.setOnClickListener {
            if (isRunning3 == false) {
                if (getterSecond3() == 0L && getterMinute3() == 0L && getterHour3() == 0L) {
                    Toast.makeText(getActivity(), "Please fill the all blank", Toast.LENGTH_LONG).show()
                } else {
                    start3(getterSecond3(), getterMinute3(), getterHour3())
                    isRunning3 = true
                }
            }
        }

        btnpause3.setOnClickListener {
            countdown_timer3.cancel()
            isPause3 = true
            isRunning3 = false
        }

        btnstop3.setOnClickListener {
            countdown_timer3.cancel()
            secPlainTxt3.setText("0")
            minPlainTxt3.setText("0")
            hourPlainTxt3.setText("0")
            isRunning3 = false
        }
    }

    fun getterSecond1() : Long {
        val sec1  = secPlainTxt1.text.toString()
        second1 = sec1.toLong() *1000
        return second1
    }
    fun getterMinute1() : Long {
        val min1  = minPlainTxt1.text.toString()
        minute1 = min1.toLong() *60000
        return minute1
    }

    fun getterHour1() : Long {
        val hours1  = hourPlainTxt1.text.toString()
        hour1 = hours1.toLong() *3600000
        return hour1
    }


    fun start1(sec : Long, minute : Long, hour : Long) {
        countdown_timer1 = object : CountDownTimer(sec+minute+hour, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                hourPlainTxt1.setText((millisUntilFinished/3600000).toString())
                minPlainTxt1.setText(((millisUntilFinished%3600000)/60000).toString())
                secPlainTxt1.setText(((millisUntilFinished%60000)/1000).toString())

            }

            override fun onFinish() {
                Toast.makeText(requireContext().applicationContext,"Countdown is over!", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }


    //-----------------------------------------------------------------


    fun getterSecond2() : Long {
        val sec2  = secPlainTxt2.text.toString()
        second2 = sec2.toLong() *1000
        return second2
    }
    fun getterMinute2() : Long {
        val min2  = minPlainTxt2.text.toString()
        minute2 = min2.toLong() *60000
        return minute2
    }

    fun getterHour2() : Long {
        val hours2  = hourPlainTxt2.text.toString()
        hour2 = hours2.toLong() *3600000
        return hour2
    }



    fun start2(sec : Long, minute : Long, hour : Long) {
        countdown_timer2 = object : CountDownTimer(sec+minute+hour, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                hourPlainTxt2.setText((millisUntilFinished/3600000).toString())
                minPlainTxt2.setText(((millisUntilFinished%3600000)/60000).toString())
                secPlainTxt2.setText(((millisUntilFinished%60000)/1000).toString())

            }

            override fun onFinish() {
                Toast.makeText(requireContext().applicationContext,"Countdown is over!", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }


    //-----------------------------------------------------------------


    fun getterSecond3() : Long {
        val sec3  = secPlainTxt3.text.toString()
        second3 = sec3.toLong() *1000
        return second3
    }
    fun getterMinute3() : Long {
        val min3  = minPlainTxt3.text.toString()
        minute3 = min3.toLong() *60000
        return minute3
    }

    fun getterHour3() : Long {
        val hours3  = hourPlainTxt3.text.toString()
        hour3 = hours3.toLong() *3600000
        return hour3
    }



    fun start3(sec : Long, minute : Long, hour : Long) {
        countdown_timer3 = object : CountDownTimer(sec+minute+hour, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                hourPlainTxt3.setText((millisUntilFinished/3600000).toString())
                minPlainTxt3.setText(((millisUntilFinished%3600000)/60000).toString())
                secPlainTxt3.setText(((millisUntilFinished%60000)/1000).toString())

            }

            override fun onFinish() {
                Toast.makeText(requireContext().applicationContext,"Countdown is over!", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }



}