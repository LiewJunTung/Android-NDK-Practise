package com.example.juntung.cpluspluscalculator

/**
 * Created by juntung on 16/1/18.
 */
interface View {
    fun showNumber(number: Int)
}

interface Presenter {
    fun addNumber(number: Int)
    fun changeOperation(operation: Long)
    fun reset()
}

