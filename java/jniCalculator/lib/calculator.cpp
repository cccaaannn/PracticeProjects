#include <jni.h>

extern "C" {

    JNIEXPORT double JNICALL Java_com_can_Calculator_add(JNIEnv*, jobject, double num1, double num2) {
        return num1 + num2;
    }

    JNIEXPORT double JNICALL Java_com_can_Calculator_subtract(JNIEnv*, jobject, double num1, double num2) {
        return num1 - num2;
    }

    JNIEXPORT double JNICALL Java_com_can_Calculator_multiply(JNIEnv*, jobject, double num1, double num2) {
        return num1 * num2;
    }

    JNIEXPORT double JNICALL Java_com_can_Calculator_divide(JNIEnv*, jobject, double num1, double num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1 / num2;
    }

}
