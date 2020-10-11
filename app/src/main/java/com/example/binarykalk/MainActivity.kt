package com.example.binarykalk

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText = findViewById<TextView>(R.id.result)

        val inputText = findViewById<EditText>(R.id.input_text)
        inputText.addTextChangedListener(afterTextChanged = {
            changeBackground(inputText, resultText.text.toString().toInt(), resultText)
        })


        val switch1 = findViewById<Switch>(R.id.s_1)
        switch1?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 1 // = XXXXXXXX or 00000001
                switch1.text = switch1.text.toString().dropLast(1) + "1"
            } else {
                number = number and 254 // = XXXXXXXX and 11111110
                switch1.text = switch1.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch2 = findViewById<Switch>(R.id.s_2)
        switch2?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 2 // = XXXXXXXX or 00000010
                switch2.text = switch2.text.toString().dropLast(1) + "1"

            } else {
                number = number and 253 // = XXXXXXXX and 11111101
                switch2.text = switch2.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch4 = findViewById<Switch>(R.id.s_4)
        switch4?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 4 // = XXXXXXXX or 00000100
                switch4.text = switch4.text.toString().dropLast(1) + "1"
            } else {
                number = number and 251 // = XXXXXXXX and 11111011
                switch4.text = switch4.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch8 = findViewById<Switch>(R.id.s_8)
        switch8?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 8 // = XXXXXXXX or 00001000
                switch8.text = switch8.text.toString().dropLast(1) + "1"
            } else {
                number = number and 247 // = XXXXXXXX and 11110111
                switch8.text = switch8.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch16 = findViewById<Switch>(R.id.s_16)
        switch16?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 16 // = XXXXXXXX or 00010000
                switch16.text = switch16.text.toString().dropLast(1) + "1"
            } else {
                number = number and 239 // = XXXXXXXX and 11101111
                switch16.text = switch16.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch32 = findViewById<Switch>(R.id.s_32)
        switch32?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 32 // = XXXXXXXX or 00100000
                switch32.text = switch32.text.toString().dropLast(1) + "1"
            } else {
                number = number and 223 // = XXXXXXXX and 11011111
                switch32.text = switch32.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch64 = findViewById<Switch>(R.id.s_64)
        switch64?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 64 // = XXXXXXXX or 01000000
                switch64.text = switch64.text.toString().dropLast(1) + "1"
            } else {
                number = number and 191 // = XXXXXXXX and 10111111
                switch64.text = switch64.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }

        val switch128 = findViewById<Switch>(R.id.s_128)
        switch128?.setOnCheckedChangeListener { _, isChecked ->
            var number = resultText.text.toString().toInt()
            if (isChecked) {
                number = number or 128 // = XXXXXXXX or 10000000
                switch128.text = switch128.text.toString().dropLast(1) + "1"
            } else {
                number = number and 127 // = XXXXXXXX and 01111111
                switch128.text = switch128.text.toString().dropLast(1) + "0"
            }
            resultText.text = "$number"
            changeBackground(inputText, number, resultText)
        }
    }

    private fun changeBackground(
        inputText: EditText,
        number: Int,
        resultText: TextView
    ) {
        val inputNumber = inputText.text.toString()
        if (inputNumber == "") {
            resultText.setBackgroundColor(Color.TRANSPARENT)
            return
        }

        val numberToCheck = inputNumber.toInt()
        if (number == numberToCheck)
            resultText.setBackgroundColor(Color.GREEN)
        else
            resultText.setBackgroundColor(Color.RED)
    }
}