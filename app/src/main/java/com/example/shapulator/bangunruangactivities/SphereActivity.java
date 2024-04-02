package com.example.shapulator.bangunruangactivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.shapulator.R;

import java.util.Locale;

public class SphereActivity extends AppCompatActivity {

    EditText etRadius;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        etRadius = findViewById(R.id.et_radius);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(v -> {
            if (!etRadius.getText().toString().isEmpty()) {
                double radius = Double.parseDouble(etRadius.getText().toString());
                double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                tvResult.setText(String.format(Locale.getDefault(), "%.2f", volume));
            } else {
                Toast.makeText(this, "Please enter the radius", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}
