package com.belajar.resepmakanan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.resepmakanan.databinding.MenuItemBinding;
import com.belajar.resepmakanan.models.Result;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuRandomAdapter extends RecyclerView.Adapter<MenuRandomAdapter.MenuRandomHolder>{
    private ArrayList< Result > results;
    private Context context;

    public MenuRandomAdapter(ArrayList< Result > results, Context context) {
        this.results = results;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList< Result > getResults() {
        return results;
    }

    public void setResults(ArrayList< Result > results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MenuRandomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuRandomHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRandomHolder holder, int position) {
        Result res = results.get(position);
        Glide.with(getContext()).load(res.getThumb()).into(holder.binding.tumbnalImage);
        holder.binding.keyMenu.setText(res.getKey());
        holder.binding.titleMasakan.setText(res.getTitle());
        holder.binding.selengkapnya.setOnClickListener(new ItemClick(position, new ItemClick.OnItemCallBack() {
            @Override
            public void OnItemClicked(View view, int position) {

            }
        }));

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class MenuRandomHolder extends RecyclerView.ViewHolder{
        private MenuItemBinding binding;

        public MenuRandomHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
