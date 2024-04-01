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

public class CubeActivity extends AppCompatActivity {

    EditText etSide;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        etSide = findViewById(R.id.et_side);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(v -> {
            if (!etSide.getText().toString().isEmpty()) {
                double side = Double.parseDouble(etSide.getText().toString());
                double volume = side * side * side;
                tvResult.setText(String.format(Locale.getDefault(), "Volume: %.2f", volume));
            } else {
                Toast.makeText(this, "Please enter the side length", Toast.LENGTH_SHORT).show();
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}
