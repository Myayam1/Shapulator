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
import com.example.shapulator.bangunruangactivities.CubeActivity;
import com.example.shapulator.bangunruangactivities.CuboidActivity;
import com.example.shapulator.bangunruangactivities.CylinderActivity;
import com.example.shapulator.bangunruangactivities.SphereActivity;

import java.util.ArrayList;
import java.util.List;

public class Menu3DFragment extends Fragment implements MenuAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private MenuAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_3d, container, false);

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

        String[] shapeNames = getResources().getStringArray(R.array.nama_bgn_ruang);
        String[] shapeDescs = getResources().getStringArray(R.array.desc_bgn_ruang);
        TypedArray shapeDrawables = getResources().obtainTypedArray(R.array.img_bgn_ruang);

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
            case "Kubus":
                intent = new Intent(requireActivity(), CubeActivity.class);
                startActivity(intent);
                break;

            case "Balok":
                intent = new Intent(requireActivity(), CuboidActivity.class);
                startActivity(intent);
                break;

            case "Bola":
                intent = new Intent(requireActivity(), SphereActivity.class);
                startActivity(intent);
                break;

            case "Tabung":
                intent = new Intent(requireActivity(), CylinderActivity.class);
                startActivity(intent);
                break;

            default:
                // Handle other shapes or unexpected cases
                break;
        }
    }

}