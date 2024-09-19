#include <jni.h>

extern "C" {

    JNIEXPORT jint JNICALL Java_com_can_PerformanceTest_sumArrayNative(JNIEnv* env, jobject, jintArray arr) {
        jint* elements = env->GetIntArrayElements(arr, 0);
        jint length = env->GetArrayLength(arr);

        jint sum = 0;
        for (jint i = 0; i < length; i++) {
            sum += elements[i];
        }

        env->ReleaseIntArrayElements(arr, elements, 0);

        return sum;
    }

}