package com.example.juntung.cpluspluscalculator

import com.example.juntung.cpluspluscalculator.CalculatorProcessor.Companion.ADDITION

/**
 * Created by juntung on 16/1/18.
 */

class MainPresenter(val view: View, val calculatorProcessor: CalculatorProcessor) : Presenter {

    private var operation = ADDITION

    init {
        calculatorProcessor.loadLibrary()
        calculatorProcessor.createCalculatorProcessor()
        calculatorProcessor.listener = object : SomeListener {
            override fun numberAdded(number: Int) {
                view.showNumber(number)
            }
        }
    }

    override fun addNumber(number: Int) {
        calculatorProcessor.addNumber(if (operation == ADDITION) number else -number)
    }

    override fun changeOperation(@CalculatorProcessor.Operation operation: Long) {
        this.operation = operation
    }

    override fun reset() {
        calculatorProcessor.reset()
    }
}