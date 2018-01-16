//
// Created by Jun Tung Liew on 16/1/18.
//

#include <jni.h>
#include "calculator.h"

void CalculatorProcessor::setJniEnv(JNIEnv *env, jobject& thiz) {
    this->env = env;
    this->thiz = thiz;
}

void CalculatorProcessor::loadJavaMethodIds() {
    jclass javaClass = env->FindClass("com/example/juntung/cpluspluscalculator/CalculatorProcessor");
    numberAddedMethodId = env->GetMethodID(javaClass, "numberAdded", "(I)V");
}

void CalculatorProcessor::addNumber(int number) {
    numbers.push_back(number);
    int result = 0;

    for (auto& n : numbers)
        result += n;
    env->CallVoidMethod(this->thiz, numberAddedMethodId, result);
}

void CalculatorProcessor::resetNumber() {
    numbers.clear();
    int result = 0;

    for (auto& n : numbers)
        result += n;
    env->CallVoidMethod(this->thiz, numberAddedMethodId, result);
}
