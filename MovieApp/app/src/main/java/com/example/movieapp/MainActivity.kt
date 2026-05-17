package com.example.movieapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        setContentView(R.layout.activity_main)

        val btnBasic = findViewById<Button>(R.id.btnBasic)
        val btnAdditional = findViewById<Button>(R.id.btnAdditional)

        // Show the Basic Details fragment by default when launching
        if (savedInstanceState == null) {
            switchFragment(MovieBasicFragment())
        }

        // Set listeners to execute dynamic replacement
        btnBasic.setOnClickListener {
            switchFragment(MovieBasicFragment())
        }

        btnAdditional.setOnClickListener {
            switchFragment(MovieAdditionalFragment())
        }
    }

    // Centralized transaction helper function
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.movieFragmentContainer, fragment)
            .setReorderingAllowed(true) // Optimizes fragment state transitions
            .commit()
    }
}