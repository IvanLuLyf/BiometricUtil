package cn.twimi.biometric;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

public class BiometricUtil {
    public static void show(final FragmentActivity activity, String title, final OnBiometricCompleted onCompleted) {
        final BiometricPrompt biometricPrompt = new BiometricPrompt(activity, Executors.newSingleThreadExecutor(), new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onCompleted.onCompleted(false);
                    }
                });
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onCompleted.onCompleted(true);
                    }
                });
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onCompleted.onCompleted(false);
                    }
                });
            }
        });
        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(title)
                .setNegativeButtonText(activity.getText(android.R.string.cancel))
                .build();
        biometricPrompt.authenticate(promptInfo);
    }

    public static boolean isSupportFinger(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT);
        }
        return false;
    }

    public interface OnBiometricCompleted {
        void onCompleted(boolean status);
    }
}
