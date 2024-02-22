package com.example.navigation_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationBar;

    /** @noinspection deprecation*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBar = findViewById(R.id.navigationBar);

        navigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.nav_home){

                    loadFrag(new HomeFragment(), false);

                }else if(id ==R.id.nav_user){
                    loadFrag(new ProfileFragment(), false);

                }else if (id ==R.id.nav_search){
                    loadFrag(new SearchFragment(),false);

                }else if (id == R.id.nav_shop){
                    loadFrag(new ShopingFragment(),false);

                }else {
                    loadFrag(new productFragment(), false);

                }


                return false;
            }
        });

        navigationBar.setSelectedItemId(R.id.nav_home);

    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
         if (flag)
             ft.add(R.id.container,fragment);
         else
             ft.replace(R.id.container,fragment);
        ft.commit();
    }

}