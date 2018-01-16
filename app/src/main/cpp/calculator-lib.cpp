//
// Created by Jun Tung Liew on 16/1/18.
//
#include <jni.h>
#include "calculator.h"

CalculatorProcessor* calculatorProcessor = NULL;

void preCreateCalculatorProcessor(JNIEnv* env, jobject thiz){
    if (calculatorProcessor != NULL){
        delete calculatorProcessor;
    }
    calculatorProcessor = new CalculatorProcessor;
    calculatorProcessor->setJniEnv(env, thiz);
    calculatorProcessor->loadJavaMethodIds();
}

extern "C" {
    JNIEXPORT void JNICALL Java_com_example_juntung_cpluspluscalculator_CalculatorProcessor_createSuperCalculatorProcessor(JNIEnv* env, jobject thiz) {
        preCreateCalculatorProcessor(env, thiz);
    }

    JNIEXPORT void JNICALL Java_com_example_juntung_cpluspluscalculator_CalculatorProcessor_reset(JNIEnv* env, jobject thiz) {
        preCreateCalculatorProcessor(env, thiz);
        calculatorProcessor->resetNumber();
    }


    JNIEXPORT void JNICALL Java_com_example_juntung_cpluspluscalculator_CalculatorProcessor_addNumber(JNIEnv* env, jobject thiz, jint number) {
        calculatorProcessor->setJniEnv(env, thiz);
        calculatorProcessor->addNumber((int) number);
    }
}