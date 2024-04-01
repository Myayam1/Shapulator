package com.example.kalkulatorbangun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kalkulatorbangun.databinding.ActivityMainBinding;
import com.example.kalkulatorbangun.menufragments.Menu2DFragment;
import com.example.kalkulatorbangun.menufragments.Menu3DFragment;
import com.example.kalkulatorbangun.menufragments.MenuProfileFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Menu2DFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bgn_datar) {
                replaceFragment(new Menu2DFragment());
            } else if (item.getItemId() == R.id.bgn_ruang) {
                replaceFragment(new Menu3DFragment());
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new MenuProfileFragment());
            }

            return true;
        });

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.constraintLayout, fragment);
        fragmentTransaction.commit();
    }
}