package com.example.bmicalculator // Make sure this matches your actual package name

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        setContentView(R.layout.activity_main)

        // Initializing the views from the layout
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val weightString = etWeight.text.toString()
            val heightString = etHeight.text.toString()

            // Validation: Ensure fields are not empty
            if (weightString.isEmpty() || heightString.isEmpty()) {
                Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Convert inputs to numbers
            val weight = weightString.toFloat()
            val heightInCm = heightString.toFloat()

            // Height must be converted to meters for the formula
            val heightInMeters = heightInCm / 100

            // Formula: weight (kg) / [height (m)]^2
            val bmi = weight / (heightInMeters * heightInMeters)

            // Format the result to 2 decimal places
            val formattedBmi = String.format("%.2f", bmi)

            // Determine the health category based on standard BMI ranges
            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi in 18.5..24.9 -> "Normal weight"
                bmi in 25.0..29.9 -> "Overweight"
                else -> "Obese"
            }

            // Display the results
            tvResult.text = "BMI: $formattedBmi\nCategory: $category"
        }
    }
}