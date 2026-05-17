
package com.example.temperatureconverter // Ensure this matches your package name

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        setContentView(R.layout.activity_main)

        // Bind the UI components
        val etTemperature = findViewById<EditText>(R.id.etTemperature)
        val toggleMode = findViewById<ToggleButton>(R.id.toggleMode)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val inputString = etTemperature.text.toString()

            // Validation: Check if the input field is empty
            if (inputString.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputTemp = inputString.toDouble()
            var resultTemp = 0.0
            var unitSymbol = ""

            // Check the state of the toggle button to apply the correct formula
            if (toggleMode.isChecked) {
                // Celsius to Fahrenheit
                resultTemp = (inputTemp * 9 / 5) + 32
                unitSymbol = "°F"
            } else {
                // Fahrenheit to Celsius
                resultTemp = (inputTemp - 32) * 5 / 9
                unitSymbol = "°C"
            }

            // Format the result to 2 decimal places
            val formattedResult = String.format("%.2f", resultTemp)

            // Update UI with the final result
            tvResult.text = "Converted Temperature:\n$formattedResult $unitSymbol"
        }
    }
}