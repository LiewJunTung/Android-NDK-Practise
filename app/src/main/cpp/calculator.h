//
// Created by Jun Tung Liew on 16/1/18.
//

#ifndef CPLUSPLUSCALCULATOR_CALCULATOR_H
#define CPLUSPLUSCALCULATOR_CALCULATOR_H

#include <jni.h>
#include <vector>

class CalculatorProcessor {
public:
    void setJniEnv(JNIEnv* env, jobject& thiz);
    void loadJavaMethodIds();
    void addNumber(int number);
    void resetNumber();

private:
    JNIEnv* env;
    jobject thiz;

    jmethodID numberAddedMethodId;
    std::vector<int> numbers;
};
#endif //CPLUSPLUSCALCULATOR_CALCULATOR_H
