package com.example.jiji.navdrawerex3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView nView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nView = (NavigationView) findViewById(R.id.nav);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        nView.setNavigationItemSelectedListener(this);

        initNavdrawer();

        displaySelectedScreen(R.id.frag1);
    }

    private void displaySelectedScreen(int itemId) {

        Fragment fragment = null;
        switch (itemId){

            case R.id.frag1:
                fragment = new Fragment_One();
                break;
            case R.id.frag2:
                fragment = new Fragment_two();
                break;
            case R.id.frag3:
                fragment = new Fragment_three();
                break;
            case R.id.item1:
                Intent intent = new Intent(this,NextActivity.class);
                startActivity(intent);
                break;
            case R.id.item2:
                Intent i = new Intent(this,NextActivity.class);
                startActivity(i);
                break;

            }

        if (fragment!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame1,fragment);
            ft.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void initNavdrawer() {

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close){

            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawView){
                super.onDrawerClosed(drawView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }
}
