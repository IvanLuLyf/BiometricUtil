# BiometricUtil

[![](https://jitpack.io/v/IvanLuLyf/BiometricUtil.svg)](https://jitpack.io/#IvanLuLyf/BiometricUtil)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![Build Status](https://travis-ci.org/IvanLuLyf/BiometricUtil.svg?branch=master)](https://travis-ci.org/IvanLuLyf/BiometricUtil)
![GitHub](https://img.shields.io/github/license/IvanLuLyf/BiometricUtil.svg?color=blue)

在Android 9.0(API level 28),```FingerprintManager``` 被标记为过时的,Google建议转为使用```BiometricPrompt```.

本项目为Android 6.0(API level 23)及以上版本生物识别的封装.

[中文](README_CN.md)

## 项目配置

添加以下内容到项目的build.gradle文件里面:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

添加项目依赖

```gradle
dependencies {
    implementation 'com.github.IvanLuLyf:BiometricUtil:1.1'
}
```

## 使用

```java
boolean flag = BiometricUtil.isSupportFinger(context); // 如果设备支持指纹识别则返回true
```

```java
BiometricUtil.show(context, title, new BiometricUtil.OnBiometricCompleted() {
    @Override
    public void onCompleted(boolean status) {
        // 返回true则指纹验证通过
    }
});
```
