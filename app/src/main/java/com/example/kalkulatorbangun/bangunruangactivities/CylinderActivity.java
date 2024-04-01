package com.example.kalkulatorbangun.bangunruangactivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.kalkulatorbangun.R;

import java.util.Locale;

public class CylinderActivity extends AppCompatActivity {

    EditText etRadius, etHeight;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        etRadius = findViewById(R.id.et_radius);
        etHeight = findViewById(R.id.et_height);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(v -> {
            if (!etRadius.getText().toString().isEmpty() && !etHeight.getText().toString().isEmpty()) {
                double radius = Double.parseDouble(etRadius.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double volume = Math.PI * radius * radius * height;
                tvResult.setText(String.format(Locale.getDefault(), "Volume: %.2f", volume));
            } else {
                Toast.makeText(this, "Please enter the radius and height", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}
