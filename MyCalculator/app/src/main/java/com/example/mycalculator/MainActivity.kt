package com.example.mycalculator



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay : TextView
    private var currentExpression = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val gridLayout = findViewById<GridLayout>(R.id.rootView)

        for(i in 0 until gridLayout.childCount){
            val button = gridLayout.getChildAt(i)
            if(button is Button){
                button.setOnClickListener{
                    val buttonText = button.text.toString()
                    handleInput(buttonText)
                }
            }
        }

        fun handleInput(value:String){
            when(value){

                "C" ->{
                    currentExpression =""
                    tvDisplay.text = "0"
                }

                "=" ->{

                    try{
                        val result = evaluateExpression(currentExpression)
                        tvDisplay.text = result
                        currentExpression = result
                    }
                    catch(e: Exception){
                        tvDisplay.text = "Error"
                        currentExpression = ""
                    }

                }


                else -> {
                    currentExpression+= value
                    tvDisplay.text = currentExpression
                }

            }
        }

        fun evaluateExpression(expression: String) : String {
            var snum : String =""
            var result:Int = 0
            for(ch in expression){
                if(ch.isDigit()){
                    snum = snum + ch
                }
                else{
                    if(ch == '+') {
                        result = result + snum.toInt()
                        snum = ""
                    }
                    else if(ch == '+') {
                        result = result + snum.toInt()
                        snum = ""
                    }
                    if(ch == '+') {
                        result = result + snum.toInt()
                        snum = ""
                    }
                    if(ch == '+') {
                        result = result + snum.toInt()
                        snum = ""
                    }

                }
            }

        }
    }
}