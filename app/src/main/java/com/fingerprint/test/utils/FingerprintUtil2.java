package com.fingerprint.test.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.UUID;


public class FingerprintUtil2 {

    private static final String TAG = "FingerprintUtils";

    private static FingerprintUtil2 instance;
    private FingerprintManagerCompat fingerprintManagerCompat;

    public static FingerprintUtil2 getInstance(Context context) throws Exception {
        if (instance == null) {
            instance = new FingerprintUtil2(context);
        }
        return instance;
    }

    private FingerprintUtil2(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Class.forName("android.hardware.fingerprint.FingerprintManager");
            } catch (Exception e) {
                throw new Exception("can not find class of android.hardware.fingerprint.FingerprintManager");
            }

            if (context.checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
                fingerprintManagerCompat = FingerprintManagerCompat.from(context);

            } else {
                throw new Exception("fingerprint permission not granted");
            }
        } else {
            throw new Exception("device android version below Android 7.0 Nougat can not support cert");
        }
    }

    // 检测是否有指纹硬件
    public boolean isHardwareDetected() {
        if (fingerprintManagerCompat != null)
            return fingerprintManagerCompat.isHardwareDetected();

        return false;
    }

}
