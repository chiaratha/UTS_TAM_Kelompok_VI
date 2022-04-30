package com.belajar.resepmakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.belajar.resepmakanan.adapter.MenuAdapter;
import com.belajar.resepmakanan.api.ApiClient;
import com.belajar.resepmakanan.databinding.ActivityHomeAcivityBinding;
import com.belajar.resepmakanan.models.RandomResep;
import com.belajar.resepmakanan.models.Result;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAcivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHomeAcivityBinding binding;
    private static final int SETTINGS_CODE = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setThemeOfApp();
        super.onCreate(savedInstanceState);
        binding = ActivityHomeAcivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.searchFood.setOnClickListener(HomeAcivity.this);
        binding.favorit.setOnClickListener(HomeAcivity.this);
        binding.receipFood.setOnClickListener(HomeAcivity.this);
        binding.help.setOnClickListener(HomeAcivity.this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(HomeAcivity.this, MenuActivity.class);
        int menu = 0;
        switch (view.getId()){
            case R.id.search_food:
                menu = 1;
                break;
            case R.id.receip_food:
                menu = 2;
                break;
            case R.id.favorit:
                menu = 4;
                break;
            case R.id.help:
                menu = 3;
        }
        intent.putExtra("menu",menu);
        startActivity(intent);
    }
    private void setThemeOfApp(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.getString("color_option","ORANGE").equals("ORANGE")){
            setTheme(R.style.OrangeTheme);
        }else if(sharedPreferences.getString("color_option","YELLOW").equals("YELLOW")){
            setTheme(R.style.YellowTheme);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivityForResult(intent,SETTINGS_CODE);
        }
        else if(item.getItemId()==R.id.setting){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivityForResult(intent,SETTINGS_CODE);
        }
        return super.onOptionsItemSelected(item);
    }
}