package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    var numberField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberField = findViewById(R.id.numberField)
    }

    var a : Double = 0.0
    var b : Double = 0.0
    var s : Char =  ' '
    
    fun numberClicked(view: View) {
        val button = view as Button

        if (numberField?.text.toString() == ("Mistake")) {
            numberField?.text = null
        }
        numberField?.append(button.text)

        if (button.text == "AC") {
            cl()
            numberField?.text = null
        }

        if (numberField?.text.toString() != "-") {
            if (button.text == "*" || button.text == "-" || button.text == "+" ||
                button.text == "/"
            ) {
                s = button.text.get(0)
                a = numberField?.text.toString()
                    .substring(0, numberField?.text.toString().length - 1).toDouble()
                numberField?.text = null
            }
        }
        if (button.text == "=") {
            b = numberField?.text.toString().toDouble()
            try {
                numberField?.setText(calc().toString())
            } catch (e: Exception) {
                numberField?.setText(e.message)
            }
            cl()
        }
    }

    fun calc() : Double {
        if (s.equals('/') and b.equals(0.0)) throw Exception("Mistake")
            when (s) {
            '+' -> return a + b
            '-' -> return a - b
            '*' -> return a * b
            '/' ->  return a / b
        }
        return 0.0
    }
    fun cl()  {
        a = 0.0
        b = 0.0
        s = ' '
    }
}