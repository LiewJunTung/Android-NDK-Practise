package com.example.juntung.cpluspluscalculator

/**
 * Created by juntung on 16/1/18.
 */
class CalculatorProcessor {

    var listener: SomeListener? = null

    fun loadLibrary(){
        System.loadLibrary("calculator-lib")
    }

    fun createCalculatorProcessor(){
        createSuperCalculatorProcessor()
    }

    external private fun createSuperCalculatorProcessor()

    external fun addNumber(number: Int)

    external fun reset()

    fun numberAdded(number: Int) {
        listener?.numberAdded(number)
    }

}