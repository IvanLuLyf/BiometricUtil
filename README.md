# BiometricUtil

[![](https://jitpack.io/v/IvanLuLyf/BiometricUtil.svg)](https://jitpack.io/#IvanLuLyf/BiometricUtil)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![Build Status](https://travis-ci.org/IvanLuLyf/BiometricUtil.svg?branch=master)](https://travis-ci.org/IvanLuLyf/BiometricUtil)
![GitHub](https://img.shields.io/github/license/IvanLuLyf/BiometricUtil.svg?color=blue)

In Android 9.0(API level 28),```FingerprintManager``` was deprecated,and Google suggest using ```BiometricPrompt```.

This repo is made for Biometric recognition in Android 6.0(API level 23) and later.

# Configure

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```gradle
dependencies {
    implementation 'com.github.IvanLuLyf:BiometricUtil:1.0'
}
```

# Usage

```java
boolean flag = BiometricUtil.isSupportFinger(context); //if device support fingerprint will return true
```

```java
BiometricUtil.show(context, title, new BiometricUtil.OnBiometricCompleted() {
    @Override
    public void onCompleted(boolean status) {
        //if true, the fingerprint is verified
    }
});
```
