package com.example.checkboxandradiobutton

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val cbJava = findViewById<CheckBox>(R.id.cbJava)
        val cbPython = findViewById<CheckBox>(R.id.cbPython)
        val cbC = findViewById<CheckBox>(R.id.cbC)
        val cbJs = findViewById<CheckBox>(R.id.cbJs)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

            val skills = mutableListOf<String>()

            if(cbJava.isChecked) skills.add("Java")
            if(cbPython.isChecked) skills.add("Python")
            if(cbC.isChecked) skills.add("C")
            if(cbJs.isChecked) skills.add("JS")

            val selectedRadioId= radioGroup.checkedRadioButtonId
            val gender = if (selectedRadioId != -1){
                findViewById<RadioButton>(selectedRadioId).text.toString()
            }
            else{
                "Not selected"
            }

            val message = "Skills:${skills.joinToString(", ")}\nGender : $gender"
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()

        }







    }
}