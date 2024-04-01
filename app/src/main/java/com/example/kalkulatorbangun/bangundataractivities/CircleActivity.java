package com.example.kalkulatorbangun.bangundataractivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

import java.util.Locale;

public class CircleActivity extends AppCompatActivity {
    EditText etRadius;
    TextView tvResult;
    Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        etRadius = findViewById(R.id.radius);
        tvResult = findViewById(R.id.tv_result_circle);
        btnCount = findViewById(R.id.btn_count);

        btnCount.setOnClickListener(v -> {
            if (etRadius.getText().toString() != null) {
                double radius = Double.parseDouble(etRadius.getText().toString());
                double area = Math.PI * radius * radius;
                tvResult.setText(String.format(Locale.getDefault(), "Area: %.2f", area));
            } else {
                Toast.makeText(this, "Please enter the radius length", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}