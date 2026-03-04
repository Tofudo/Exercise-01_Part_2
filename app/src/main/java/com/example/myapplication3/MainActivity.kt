package com.example.myapplication3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private var mCounter = 0
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvCounter)

        // Restore saved counter if available
        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt("COUNT_KEY", 0)
            tvCounter.text = mCounter.toString()
        }

        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        btnIncrement.setOnClickListener {
            mCounter++
            tvCounter.text = mCounter.toString()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Save counter value before rotation or destruction
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT_KEY", mCounter)
    }
}