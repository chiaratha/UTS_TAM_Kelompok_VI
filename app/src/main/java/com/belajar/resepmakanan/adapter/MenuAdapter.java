package com.belajar.resepmakanan.adapter;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.resepmakanan.DetailMenuFragment;
import com.belajar.resepmakanan.R;
import com.belajar.resepmakanan.databinding.MenuItemBinding;
import com.belajar.resepmakanan.models.Result;
import com.belajar.resepmakanan.models.ResultSearch;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter< MenuAdapter.MenuHolder >{
    private ArrayList< ResultSearch > results;
    private Context context;

    public MenuAdapter(ArrayList< ResultSearch > results, Context context) {
        this.results = results;
        this.context = context;
    }

    public ArrayList< ResultSearch > getResults() {
        return results;
    }

    public void setResults(ArrayList< ResultSearch > results) {
        this.results = results;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuHolder(MenuItemBinding
                .inflate(LayoutInflater
                        .from(parent.getContext())
                        ,parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        ResultSearch result = results.get(position);
        Glide.with(context).load(result.getThumb()).into(holder.binding.tumbnalImage);
        holder.binding.titleMasakan.setText(result.getTitle());
        holder.binding.keyMenu.setText(result.getKey());
        holder.binding.selengkapnya.setOnClickListener(new ItemClick(position, new ItemClick.OnItemCallBack() {
            @Override
            public void OnItemClicked(View view, int position) {
                Bundle bundle = new Bundle();
                Fragment fragment = new DetailMenuFragment();
                bundle.putString("title",result.getTitle());
                bundle.putString("key",result.getKey());
                bundle.putString("times",result.getTimes());
                bundle.putString("dificulty",result.getDifficulty());
                bundle.putString("portion",result.getServing());
                bundle.putString("tumb",result.getThumb());
                fragment.setArguments(bundle);
                ((FragmentActivity) view.getContext())
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_fragment,fragment)
                        .addToBackStack("menu")
                        .commit();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class MenuHolder extends RecyclerView.ViewHolder{
        private MenuItemBinding binding;
        public MenuHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
