package com.belajar.resepmakanan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belajar.resepmakanan.adapter.MenuRandomAdapter;
import com.belajar.resepmakanan.api.ApiClient;
import com.belajar.resepmakanan.databinding.FragmentFavoriteBinding;
import com.belajar.resepmakanan.models.RandomResep;
import com.belajar.resepmakanan.models.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FavoriteFragment extends Fragment {
    private FragmentFavoriteBinding binding;
    private ArrayList< Result > results;
    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        reqResep();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void reqResep(){
        Call<RandomResep>resepCall = ApiClient.getService().getRandomResep();
        resepCall.enqueue(new Callback< RandomResep >() {
            @Override
            public void onResponse(Call< RandomResep > call, Response< RandomResep > response) {
                if (response.isSuccessful()){
                    results = response.body().getResults();
                    MenuRandomAdapter adapter = new MenuRandomAdapter(results, getContext());
                    binding.containerResepFav.setHasFixedSize(true);
                    binding.containerResepFav.setAdapter(adapter);
                    binding.containerResepFav.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }

            @Override
            public void onFailure(Call< RandomResep > call, Throwable t) {

            }
        });
    }


}