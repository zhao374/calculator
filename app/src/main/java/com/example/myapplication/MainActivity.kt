package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2=findViewById(R.id.calculate)
        button2.setOnClickListener { calculate() }
        displayResult(0.0)

    }

    private fun calculate() {
        val textview1: TextView =findViewById(R.id.number1)
        val textview2: TextView =findViewById(R.id.number2)
        val num1 = textview1.text.toString().toDoubleOrNull()
        val num2 = textview2.text.toString().toDoubleOrNull()
        if (num1 == null) {
            Toast.makeText(applicationContext,"Enter number 1",Toast.LENGTH_SHORT).show()
            displayResult(0.0)
            return
        }
        if (num2 == null) {
            Toast.makeText(applicationContext,"Enter number 2",Toast.LENGTH_SHORT).show()
            displayResult(0.0)
            return
        }
        val radio:RadioGroup=findViewById(R.id.radioGroup)
        var calResult = when(radio.checkedRadioButtonId){
            R.id.add_opt -> num1+num2
            R.id.sub_opt -> num1-num2
            R.id.mul_opt -> num1*num2
            R.id.div_opt -> if (num2 != 0.0) {
                num1/num2
            } else {
                Toast.makeText(applicationContext,"Divide by 0",Toast.LENGTH_SHORT).show()
                0.0 }
            else -> { 0.0 }
        }

        calResult = String.format("%.2f", calResult).toDouble()
        ResultViewModel.instance.loadResult(calResult)
        val result1:TextView=findViewById(R.id.calcResult)
        result1.setText(ResultViewModel.instance.retrieveResult().toString())
    }

    fun displayResult(result: Double) {
        // 结果显示
        val result1:TextView=findViewById(R.id.calcResult)
        result1.setText(ResultViewModel.instance.retrieveResult().toString())
    }

}
