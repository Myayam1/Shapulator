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

public class SquareActivity extends AppCompatActivity {
    EditText etWidth, etHeight;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        etWidth = findViewById(R.id.et_width);
        etHeight = findViewById(R.id.et_height);
        tvResult = findViewById(R.id.tv_result_square);
        btnCalculate = findViewById(R.id.btn_count);

        btnCalculate.setOnClickListener(v -> {
            if (!etWidth.getText().toString().isEmpty() && !etHeight.getText().toString().isEmpty()) {
                double width = Double.parseDouble(etWidth.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double area = width * height;
                tvResult.setText(String.format(Locale.getDefault(), "%.2f", area));
            } else {
                Toast.makeText(this, "Please enter both width and height", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }


}