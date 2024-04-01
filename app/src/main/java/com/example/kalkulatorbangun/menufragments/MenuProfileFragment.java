package com.example.kalkulatorbangun.menufragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;

import com.example.kalkulatorbangun.R;

public class MenuProfileFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_menu_2d, container, false);

        WindowCompat.setDecorFitsSystemWindows(getActivity().getWindow(), false);
        return view;
    }
}
