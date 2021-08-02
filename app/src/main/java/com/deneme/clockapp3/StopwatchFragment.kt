package com.deneme.clockapp3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.deneme.clockapp3.Constants.TIMER_INTERVAL
import com.deneme.clockapp3.Utility.getFormattedStopWatch
import com.deneme.clockapp3.databinding.FragmentStopwatchBinding

class StopwatchFragment : Fragment() {

    private var _binding : FragmentStopwatchBinding? = null
    private val binding get() = _binding!!

    private val mInterval1 = TIMER_INTERVAL
    private var mHandler1: Handler? = null

    private var timeInSeconds1 = 0L
    private var startButtonClicked1 = false

    private val mInterval2 = TIMER_INTERVAL
    private var mHandler2: Handler? = null

    private var timeInSeconds2 = 0L
    private var startButtonClicked2 = false

    private val mInterval3 = TIMER_INTERVAL
    private var mHandler3: Handler? = null

    private var timeInSeconds3 = 0L
    private var startButtonClicked3 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStopwatchBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStopWatch1()

        binding.resetButton1.setOnClickListener {
            stopTimer1()
            resetTimerView1()
        }

        binding.startOrStopTextView1.setOnClickListener {
            if (!startButtonClicked1) {
                startTimer1()
                startTimerView1()
            } else {
                stopTimer1()
                stopTimerView1()
            }
        }

        initStopWatch2()

        binding.resetButton2.setOnClickListener {
            stopTimer2()
            resetTimerView2()
        }

        binding.startOrStopTextView2.setOnClickListener {
            if (!startButtonClicked2) {
                startTimer2()
                startTimerView2()
            } else {
                stopTimer2()
                stopTimerView2()
            }
        }


        initStopWatch3()

        binding.resetButton3.setOnClickListener {
            stopTimer3()
            resetTimerView3()
        }

        binding.startOrStopTextView3.setOnClickListener {
            if (!startButtonClicked3) {
                startTimer3()
                startTimerView3()
            } else {
                stopTimer3()
                stopTimerView3()
            }
        }



        binding.stopwatchplus2.setOnClickListener {
            binding.editTextTextPersonName2.visibility = View.VISIBLE
            binding.stopwatchminus2.visibility = View.VISIBLE
            binding.textViewStopWatch2.visibility = View.VISIBLE
            binding.resetButton2.visibility = View.VISIBLE
            binding.startOrStopTextView2.visibility = View.VISIBLE
            binding.stopwatchplus3.visibility = View.VISIBLE
        }


        binding.stopwatchminus2.setOnClickListener {
            binding.editTextTextPersonName2.visibility = View.INVISIBLE
            binding.stopwatchminus2.visibility = View.INVISIBLE
            binding.textViewStopWatch2.visibility = View.INVISIBLE
            binding.resetButton2.visibility = View.INVISIBLE
            binding.startOrStopTextView2.visibility = View.INVISIBLE
            binding.stopwatchminus2.visibility = View.INVISIBLE
        }


        binding.stopwatchplus3.setOnClickListener {
            binding.editTextTextPersonName3.visibility = View.VISIBLE
            binding.stopwatchminus3.visibility = View.VISIBLE
            binding.textViewStopWatch3.visibility = View.VISIBLE
            binding.resetButton3.visibility = View.VISIBLE
            binding.startOrStopTextView3.visibility = View.VISIBLE
            binding.stopwatchplus3.visibility = View.VISIBLE
        }

        binding.stopwatchminus3.setOnClickListener {
            binding.editTextTextPersonName3.visibility = View.INVISIBLE
            binding.stopwatchminus3.visibility = View.INVISIBLE
            binding.textViewStopWatch3.visibility = View.INVISIBLE
            binding.resetButton3.visibility = View.INVISIBLE
            binding.startOrStopTextView3.visibility = View.INVISIBLE
            binding.stopwatchminus3.visibility = View.INVISIBLE
            binding.stopwatchplus3.visibility = View.INVISIBLE

        }
    }

    private fun initStopWatch1() {
        binding.textViewStopWatch1.text = getString(R.string.init_stop_watch_value)
    }

    private fun resetTimerView1() {

        timeInSeconds1 = 0
        startButtonClicked1 = false
        binding.startOrStopTextView1.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView1.setText(R.string.start)
        initStopWatch1()

    }


    private fun stopTimerView1() {
        binding.startOrStopTextView1.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView1.setText(R.string.resume)
        startButtonClicked1 = false
    }

    private fun startTimerView1() {

        binding.startOrStopTextView1.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.stop
            )
        )
        binding.startOrStopTextView1.setText(R.string.stop)
        startButtonClicked1 = true

    }

    private fun startTimer1() {
        mHandler1 = Handler(Looper.getMainLooper())
        mStatusChecker1.run()
    }

    private fun stopTimer1() {
        mHandler1?.removeCallbacks(mStatusChecker1)
    }

    private var mStatusChecker1: Runnable = object : Runnable {
        override fun run() {
            try {
                timeInSeconds1 += 1
                Log.e("timeInSeconds", timeInSeconds1.toString())
                updateStopWatchView1(timeInSeconds1)
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler1!!.postDelayed(this, mInterval1.toLong())
            }
        }
    }

    private fun updateStopWatchView1(timeInSeconds1: Long) {
        val formattedTime1 = getFormattedStopWatch((timeInSeconds1 * 1000))
        Log.e("formattedTime", formattedTime1)
        binding.textViewStopWatch1.text = formattedTime1
    }




    //----------------------------------------------------------------------



    private fun initStopWatch2() {
        binding.textViewStopWatch2.text = getString(R.string.init_stop_watch_value)
    }

    private fun resetTimerView2() {

        timeInSeconds2 = 0
        startButtonClicked2 = false
        binding.startOrStopTextView2.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView2.setText(R.string.start)
        initStopWatch2()

    }


    private fun stopTimerView2() {
        binding.startOrStopTextView2.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView2.setText(R.string.resume)
        startButtonClicked2 = false
    }

    private fun startTimerView2() {

        binding.startOrStopTextView2.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.stop
            )
        )
        binding.startOrStopTextView2.setText(R.string.stop)
        startButtonClicked2 = true

    }

    private fun startTimer2() {
        mHandler2 = Handler(Looper.getMainLooper())
        mStatusChecker2.run()
    }

    private fun stopTimer2() {
        mHandler2?.removeCallbacks(mStatusChecker2)
    }

    private var mStatusChecker2: Runnable = object : Runnable {
        override fun run() {
            try {
                timeInSeconds2 += 1
                Log.e("timeInSeconds", timeInSeconds2.toString())
                updateStopWatchView2(timeInSeconds2)
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler2!!.postDelayed(this, mInterval2.toLong())
            }
        }
    }

    private fun updateStopWatchView2(timeInSeconds2: Long) {
        val formattedTime2 = getFormattedStopWatch((timeInSeconds2 * 1000))
        Log.e("formattedTime", formattedTime2)
        binding.textViewStopWatch2.text = formattedTime2
    }



    //----------------------------------------------------------------------



    private fun initStopWatch3() {
        binding.textViewStopWatch3.text = getString(R.string.init_stop_watch_value)
    }

    private fun resetTimerView3() {

        timeInSeconds3 = 0
        startButtonClicked3 = false
        binding.startOrStopTextView3.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView3.setText(R.string.start)
        initStopWatch3()

    }


    private fun stopTimerView3() {
        binding.startOrStopTextView3.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.teal_700
            )
        )
        binding.startOrStopTextView3.setText(R.string.resume)
        startButtonClicked3 = false
    }

    private fun startTimerView3() {

        binding.startOrStopTextView3.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.stop
            )
        )
        binding.startOrStopTextView3.setText(R.string.stop)
        startButtonClicked3 = true

    }

    private fun startTimer3() {
        mHandler3 = Handler(Looper.getMainLooper())
        mStatusChecker3.run()
    }

    private fun stopTimer3() {
        mHandler3?.removeCallbacks(mStatusChecker3)
    }

    private var mStatusChecker3: Runnable = object : Runnable {
        override fun run() {
            try {
                timeInSeconds3 += 1
                Log.e("timeInSeconds", timeInSeconds3.toString())
                updateStopWatchView3(timeInSeconds3)
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler3!!.postDelayed(this, mInterval3.toLong())
            }
        }
    }

    private fun updateStopWatchView3(timeInSeconds3: Long) {
        val formattedTime3 = getFormattedStopWatch((timeInSeconds3 * 1000))
        Log.e("formattedTime", formattedTime3)
        binding.textViewStopWatch3.text = formattedTime3
    }



    override fun onDestroy() {
        super.onDestroy()
        stopTimer1()
        stopTimer2()
        stopTimer3()
        _binding = null
    }
}