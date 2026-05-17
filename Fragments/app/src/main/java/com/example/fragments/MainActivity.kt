package com.example.fragments

import com.example.Fragments.StudentDetailsFragment


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        setContentView(R.layout.activity_main)

        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnMarks = findViewById<Button>(R.id.btnMarks)

        // Load the default fragment (Basic Details) when app starts
        if (savedInstanceState == null) {
            replaceFragment(StudentDetailsFragment())
        }

        // Set click listeners to swap fragments
        btnDetails.setOnClickListener {
            replaceFragment(StudentDetailsFragment())
        }

        btnMarks.setOnClickListener {
            replaceFragment(StudentMarksFragment())
        }
    }

    // Helper function to manage fragment switching cleanly
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replaces whatever is inside the FrameLayout with our target fragment
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}