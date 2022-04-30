package com.belajar.resepmakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.belajar.resepmakanan.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    private Bundle bundle;
    private static final int SETTINGS_CODE = 234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        startFragmentView();
    }

    private void startFragmentView() {
        Fragment fragment = null;
        switch (bundle.getInt("menu")){
            case 1:
                fragment = new SearchFragment();
                break;
            case 2:
                fragment = new ReceipFood();
                break;
            case 3:
                fragment = new HelpFragment();
                break;
            case 4:
                fragment = new FavoriteFragment();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_fragment, fragment)
                .commit();
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
    private void setThemeOfApp(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.getString("color_option","ORANGE").equals("ORANGE")){
            setTheme(R.style.OrangeTheme);
        }else if(sharedPreferences.getString("color_option","YELLOW").equals("YELLOW")){
            setTheme(R.style.YellowTheme);
        }
    }

}