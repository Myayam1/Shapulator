package com.example.kalkulatorbangun;

import com.example.kalkulatorbangun.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPass;
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        Intent mainAct = new Intent(LoginActivity.this, MainActivity.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUser.getText().toString().equals("ZakiFirasi") && etPass.getText().toString().equals("Firas123")) {
                    startActivity(mainAct);
                } else {
                    Toast.makeText(LoginActivity.this, "Maaf, Username atau Password anda salah. Mohon coba lagi.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }
}