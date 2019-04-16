package cn.twimi.biometricutil;

import androidx.appcompat.app.AppCompatActivity;
import cn.twimi.util.BiometricUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnVerify = findViewById(R.id.btn_verify);
        final TextView txtResult = findViewById(R.id.txt_result);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiometricUtil.show(MainActivity.this, "Verify", new BiometricUtil.OnBiometricCompleted() {
                    @Override
                    public void onCompleted(boolean status) {
                        /* Callback */
                        txtResult.setText(status ? R.string.txt_success : R.string.txt_failed);
                    }
                });
            }
        });

        /* Check Support */
        if (!BiometricUtil.isSupportFinger(this)) {
            txtResult.setText(R.string.txt_no_support);
        }
    }
}
