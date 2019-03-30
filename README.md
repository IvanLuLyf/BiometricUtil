# BiometricUtil

In Android 9.0(API level 28),```FingerprintManager``` was deprecated,and Google suggest using ```BiometricPrompt```.

This repo is made for Biometric recognition in Android 6.0(API level 23) and later.

# Configure

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```
dependencies {
    implementation 'com.github.IvanLuLyf:BiometricUtil:1.0'
}
```

# Usage

```java
boolean flag = BiometricUtil.isSupportFinger(context); //if device support fingerprint will return true
```

```
BiometricUtil.show(context, title, new BiometricUtil.OnBiometricCompleted() {
    @Override
    public void onCompleted(boolean status) {
        //if true, the fingerprint is verified
    }
});
```