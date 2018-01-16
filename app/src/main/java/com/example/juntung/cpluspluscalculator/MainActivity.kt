package com.example.juntung.cpluspluscalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntDef
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var calculatorProcessor: CalculatorProcessor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCalculatorProcessor()

        // Example of a call to a native method
       // sample_text.text = stringFromJNI("HELLO JT LIUWE", 12)
        call_button_1.setOnClickListener { addNumber(1)}
        call_button_2.setOnClickListener { addNumber(2)}
        call_button_3.setOnClickListener { addNumber(3)}
        call_button_4.setOnClickListener { addNumber(4)}
        call_button_5.setOnClickListener { addNumber(5)}
        call_button_6.setOnClickListener { addNumber(6)}
        call_button_7.setOnClickListener { addNumber(7)}
        call_button_8.setOnClickListener { addNumber(8)}
        call_button_9.setOnClickListener { addNumber(9)}
        c_button.setOnClickListener { calculatorProcessor?.reset() }
    }

    private fun initCalculatorProcessor() {
        calculatorProcessor = CalculatorProcessor()
        calculatorProcessor?.loadLibrary()
        calculatorProcessor?.createCalculatorProcessor()
        calculatorProcessor?.listener = object : SomeListener {
            override fun numberAdded(number: Int) {
                sample_text.text = String.format("%d", number)
            }
        }

    }

    fun addNumber(number: Int) {
        calculatorProcessor?.addNumber(number)
    }
//
//
//
//
//    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    external fun stringFromJNI(hello: String, number: Int): String
//
//    external fun callAddition(number1: Int, number2: Int): Int
//
//
//    companion object {
//        const val ADDITION = 0
//        const val SUBTRACTION = 1
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}
