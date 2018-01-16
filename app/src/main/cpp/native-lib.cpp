#include <jni.h>
#include <string>

int sum(int a, int b){
    return a + b;
}

int subtract(int a, int b){
    return a - b;
}

extern "C" {
    JNIEXPORT jstring JNICALL Java_com_example_juntung_cpluspluscalculator_MainActivity_stringFromJNI(
            JNIEnv *env,
            jobject /* this */,
            jstring hello123, jint number) {
        // std::string hello = "Hello from C++";
        char buf[14];
        std::string hello = env->GetStringUTFChars(hello123, NULL);
        int num = (int) number;
        sprintf(buf, "%d", num);
        printf("%s\n", buf);
        std::string result = hello + buf;
        return env->NewStringUTF(result.c_str());
    }

    JNIEXPORT jint JNICALL Java_com_example_juntung_cpluspluscalculator_MainActivity_callAddition(
            JNIEnv *env,
            jobject /* this */,
            jint number1, jint number2) {
        int num1 = (int) number1;
        int num2 = (int) number2;
        return sum(num1, num2);
    }


}

