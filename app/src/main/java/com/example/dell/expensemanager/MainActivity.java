package com.example.dell.expensemanager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);

        drawerToggle = setupDrawerToggle();

        mDrawer.addDrawerListener(drawerToggle);

    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.Open,  R.string.Close);
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    public void selectDrawerItem(MenuItem menuItem) {

        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.Home:
                fragmentClass =Home.class;
                break;
            case R.id.Day:
                fragmentClass =Day.class;
                break;
            case R.id.Week:
                fragmentClass =Week.class;
                break;
            case R.id.Month:
                fragmentClass =Month.class;
                break;
            case R.id.Year:
                fragmentClass =Year.class;
                break;
            case R.id.All:
                fragmentClass =All.class;
                break;
            case R.id.Backup:
                fragmentClass =Backup.class;
                break;
                case R.id.Restore:
                fragmentClass =Restore.class;
                break;
                case R.id.PDF:
                fragmentClass =Report.class;
                break;
            case R.id.Logout:
                finish();
                Intent intentLoadNewActivity=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentLoadNewActivity);
        default:
                fragmentClass =Home.class;

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        mDrawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Home) {

        } else if (id == R.id.Day) {

        } else if (id == R.id.Week) {

        } else if (id == R.id.Month) {

        } else if (id == R.id.Year) {

        } else if (id == R.id.All) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }
}