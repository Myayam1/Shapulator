package com.example.shapulator.menufragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;

import com.example.shapulator.LoginActivity;
import com.example.shapulator.R;

public class MenuProfileFragment extends Fragment {
    Button btnLogOut;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Intent loginPage = new Intent(getActivity(), LoginActivity.class);
        btnLogOut = view.findViewById(R.id.btn_logout);

        btnLogOut.setOnClickListener(v -> {
            startActivity(loginPage);
        });

        WindowCompat.setDecorFitsSystemWindows(getActivity().getWindow(), false);
        return view;
    }
}
