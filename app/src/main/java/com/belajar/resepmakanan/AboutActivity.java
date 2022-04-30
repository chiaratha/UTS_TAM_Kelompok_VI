package com.belajar.resepmakanan;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class AboutActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setThemeOfApp();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_main);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
