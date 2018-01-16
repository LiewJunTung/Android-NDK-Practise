package com.example.juntung.cpluspluscalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntDef
import com.example.juntung.cpluspluscalculator.CalculatorProcessor.Companion.ADDITION
import com.example.juntung.cpluspluscalculator.CalculatorProcessor.Companion.SUBTRACTION
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private var presenter: Presenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()

        // Example of a call to a native method
       // sample_text.text = stringFromJNI("HELLO JT LIUWE", 12)
        call_button_1.setOnClickListener { presenter?.addNumber(1)}
        call_button_2.setOnClickListener { presenter?.addNumber(2)}
        call_button_3.setOnClickListener { presenter?.addNumber(3)}
        call_button_4.setOnClickListener { presenter?.addNumber(4)}
        call_button_5.setOnClickListener { presenter?.addNumber(5)}
        call_button_6.setOnClickListener { presenter?.addNumber(6)}
        call_button_7.setOnClickListener { presenter?.addNumber(7)}
        call_button_8.setOnClickListener { presenter?.addNumber(8)}
        call_button_9.setOnClickListener { presenter?.addNumber(9)}
        c_button.setOnClickListener { presenter?.reset() }
        plus_button.setOnClickListener { presenter?.changeOperation(ADDITION) }
        subtract_button.setOnClickListener { presenter?.changeOperation(SUBTRACTION) }

    }

    private fun initPresenter() {
        presenter = MainPresenter(this, CalculatorProcessor())

    }


    override fun showNumber(number: Int) {
        sample_text.text = String.format("%d", number)
    }


}
