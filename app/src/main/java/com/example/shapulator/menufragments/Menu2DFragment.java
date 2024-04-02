package com.example.shapulator.menufragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shapulator.R;
import com.example.shapulator.bangundataractivities.CircleActivity;
import com.example.shapulator.bangundataractivities.RightTriangleActivity;
import com.example.shapulator.bangundataractivities.SquareActivity;
import com.example.shapulator.bangundataractivities.TriangleActivity;

import java.util.ArrayList;
import java.util.List;

public class Menu2DFragment extends Fragment implements MenuAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private MenuAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_2d, container, false);

        recyclerView = view.findViewById(R.id.items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new MenuAdapter(getList());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        WindowCompat.setDecorFitsSystemWindows(getActivity().getWindow(), false);
        return view;
    }

    private List<MenuModel> getList() {
        List<MenuModel> myModels = new ArrayList<>();

        String[] shapeNames = getResources().getStringArray(R.array.nama_bgn_datar);
        String[] shapeDescs = getResources().getStringArray(R.array.desc_bgn_datar);
        TypedArray shapeDrawables = getResources().obtainTypedArray(R.array.img_bgn_datar);

        for (int i = 0; i < shapeNames.length; i++) {
            Drawable drawable = shapeDrawables.getDrawable(i);
            myModels.add(new MenuModel(shapeNames[i], shapeDescs[i], drawable));
        }

        return myModels;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent;

        switch (adapter.getItem(position).getName()) {
            case "Persegi":
                intent = new Intent(requireActivity(), SquareActivity.class);
                startActivity(intent);
                break;
            case "Segitiga":
                intent = new Intent(requireActivity(), TriangleActivity.class);
                startActivity(intent);
                break;

            case "Lingkaran":
                intent = new Intent(requireActivity(), CircleActivity.class);
                startActivity(intent);
                break;

            case "Segitiga Siku-Siku":
                intent = new Intent(requireActivity(), RightTriangleActivity.class);
                startActivity(intent);
                break;
        }
    }
}