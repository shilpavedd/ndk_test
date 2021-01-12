#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jint JNICALL
Java_com_example_sumapplication_MainActivity_sumFromJNI(JNIEnv *env, jobject thiz, jlong num1,
                                                        jlong num2) {
    return (num1+num2);
}