package com.belajar.resepmakanan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.belajar.resepmakanan.adapter.MenuAdapter;
import com.belajar.resepmakanan.api.ApiClient;
import com.belajar.resepmakanan.databinding.FragmentSearchBinding;
import com.belajar.resepmakanan.models.RandomResep;
import com.belajar.resepmakanan.models.Result;
import com.belajar.resepmakanan.models.ResultSearch;
import com.belajar.resepmakanan.models.SearchResep;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentSearchBinding binding;
    private ArrayList< ResultSearch > results;
    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.searchInputBar.setOnQueryTextListener(this);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        searchMenuResep(query.toLowerCase(Locale.ROOT));
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.trim().isEmpty()){
            results = null;
        }
        return true;
    }




    public void searchMenuResep(String menu){
        Call< SearchResep > resepCall = ApiClient.getService().getSearhResep(menu);
        resepCall.enqueue(new Callback< SearchResep >() {
            @Override
            public void onResponse(Call< SearchResep > call, Response< SearchResep > response) {
                if (response.isSuccessful()){
                    results = response.body().getResults();
                    MenuAdapter adapter = new MenuAdapter(results,getContext());
                    binding.containerListMenu.setHasFixedSize(true);
                    binding.containerListMenu.setAdapter(adapter);
                    binding.containerListMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }

            @Override
            public void onFailure(Call< SearchResep > call, Throwable t) {

            }
        });
    }

}