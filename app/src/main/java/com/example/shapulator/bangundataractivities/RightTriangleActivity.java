package com.example.shapulator.bangundataractivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shapulator.R;

import java.util.Locale;

public class RightTriangleActivity extends AppCompatActivity {
    EditText etBase, etHeight;
    TextView tvResult;
    Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_triangle);

        etBase = findViewById(R.id.et_base);
        etHeight = findViewById(R.id.et_height);
        tvResult = findViewById(R.id.tv_result);
        btnCount = findViewById(R.id.btn_count);

        btnCount.setOnClickListener(v -> {
            if (!etBase.getText().toString().isEmpty() && !etHeight.getText().toString().isEmpty()) {
                double base = Double.parseDouble(etBase.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double area = 0.5 * base * height;
                tvResult.setText(String.format(Locale.getDefault(), "%.2f", area));
            } else {
                Toast.makeText(this, "Please enter both base and height", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }

}