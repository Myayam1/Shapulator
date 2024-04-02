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

public class CuboidActivity extends AppCompatActivity {

    EditText etLength, etWidth, etHeight;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuboid);

        etLength = findViewById(R.id.et_length);
        etWidth = findViewById(R.id.et_width);
        etHeight = findViewById(R.id.et_height);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(v -> {
            if (!etLength.getText().toString().isEmpty()
                    && !etWidth.getText().toString().isEmpty()
                    && !etHeight.getText().toString().isEmpty()) {
                double length = Double.parseDouble(etLength.getText().toString());
                double width = Double.parseDouble(etWidth.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double volume = length * width * height;
                tvResult.setText(String.format(Locale.getDefault(), "%.2f", volume));
            } else {
                Toast.makeText(this, "Please enter all dimensions", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}
