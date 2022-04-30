package com.belajar.resepmakanan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.belajar.resepmakanan.databinding.FragmentDetailMenuBinding;
import com.bumptech.glide.Glide;

public class DetailMenuFragment extends Fragment {
    private Bundle bundle;
    private FragmentDetailMenuBinding binding;
    public DetailMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDetailMenuBinding.inflate(inflater, container, false);
        bundle = this.getArguments();
        if (bundle != null){
            Glide.with(getContext()).load(bundle.getString("tumb")).into(binding.gambarMakanan);
            binding.keyMenu.setText(bundle.getString("key"));
            binding.tingkatMenu.setText(bundle.getString("dificulty"));
            binding.namaMenu.setText(bundle.getString("title"));
            binding.waktuMasak.setText(bundle.getString("times"));
            binding.porsiMenu.setText(bundle.getString("portion"));
        }
        return binding.getRoot();
    }


}