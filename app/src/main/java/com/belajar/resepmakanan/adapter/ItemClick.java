package com.belajar.resepmakanan.adapter;

import android.view.View;

public class ItemClick implements View.OnClickListener {

    private int position;
    private OnItemCallBack onItemCallBack;

    @Override
    public void onClick(View view) {
        onItemCallBack.OnItemClicked(view, position);
    }

    public ItemClick(int position, OnItemCallBack callBack){
        this.position = position;
        this.onItemCallBack = callBack;
    }

    public interface OnItemCallBack{
        void OnItemClicked(View view, int position);
    }
}
