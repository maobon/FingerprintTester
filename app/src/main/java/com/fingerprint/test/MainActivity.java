package com.fingerprint.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fingerprint.test.utils.FingerprintUtil;
import com.fingerprint.test.utils.FingerprintUtil2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "gmrz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test).setOnClickListener(this);
        findViewById(R.id.btn_test2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.btn_test:
                    // FingerprintManager
                    boolean isHardwareDetected = FingerprintUtil.getInstance(this).isHardwareDetected();
                    Log.wtf(TAG, "isHardwareDetected=" + isHardwareDetected);
                    Toast.makeText(this, "isHardwareDetected= " + isHardwareDetected, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_test2:
                    // FingerprintManagerCompat
                    boolean isHardwareDetected2 = FingerprintUtil2.getInstance(this).isHardwareDetected();
                    Log.wtf(TAG, "isHardwareDetected2=" + isHardwareDetected2);
                    Toast.makeText(this, "isHardwareDetected2= " + isHardwareDetected2, Toast.LENGTH_SHORT).show();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}