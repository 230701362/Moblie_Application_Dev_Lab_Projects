package com.example.panverification // Match this with your project package name

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        setContentView(R.layout.activity_main)

        // Bind layout views
        val etPanCard = findViewById<EditText>(R.id.etPanCard)
        val etPincode = findViewById<EditText>(R.id.etPincode)
        val btnValidate = findViewById<Button>(R.id.btnValidate)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnValidate.setOnClickListener {
            val panInput = etPanCard.text.toString().trim()
            val pincodeInput = etPincode.text.toString().trim()

            // 1. Check if fields are empty
            if (panInput.isEmpty() || pincodeInput.isEmpty()) {
                tvStatus.text = "Error: Both fields are required!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 2. Validate PAN Card (Alphanumeric only, exactly 10 characters)
            // Regex: ^[a-zA-Z0-9]{10}$ ensures strictly letters and numbers for exactly 10 characters
            val panRegex = Regex("^[a-zA-Z0-9]{10}$")
            if (!panInput.matches(panRegex)) {
                tvStatus.text = "Error: PAN Card must be exactly 10 alphanumeric characters!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 3. Validate Pincode (Numeric only, exactly 6 digits)
            // Regex: ^[0-9]{6}$ ensures strictly digits for exactly 6 characters
            val pincodeRegex = Regex("^[0-9]{6}$")
            if (!pincodeInput.matches(pincodeRegex)) {
                tvStatus.text = "Error: Pincode must be exactly 6 numeric digits!"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // If all validation rules pass
            tvStatus.text = "Validation Successful!"
            tvStatus.setTextColor(Color.parseColor("#4CAF50")) // Green color
        }
    }
}