package com.example.juntung.cpluspluscalculator

import android.support.annotation.IntDef

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

    fun numberAdded(@Operation number: Int) {
        listener?.numberAdded(number)
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(ADDITION, SUBTRACTION)
    annotation class Operation

    companion object {
        const val ADDITION: Long = 1L
        const val SUBTRACTION: Long = 2L
    }

}