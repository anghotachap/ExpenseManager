package com.example.dell.expensemanager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton Day,Week,Month,Year,All;
    CardView Home,Entertainment,Cloths,Travelling,Sports;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home=(CardView)findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,AddHomeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Entertainment=(CardView)findViewById(R.id.Entertainment);
        Entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,AddEntertainmentActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Travelling=(CardView)findViewById(R.id.Travelling);
        Travelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,AddTravellingActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Cloths=(CardView)findViewById(R.id.Cloths);
        Cloths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,AddClothsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Sports=(CardView)findViewById(R.id.Sports);
        Sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,AddSportsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.Day:
                        Intent i1 = new Intent(MainActivity.this, DayActivity.class);
                        startActivity(i1);
                        break;
                    case R.id.Week:
                        Intent i2 = new Intent(MainActivity.this,WeekActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.Month:
                        Intent i3 = new Intent(MainActivity.this,MonthActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.Year:
                        Intent i4 = new Intent(MainActivity.this,YearActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.All:
                        Intent i5 = new Intent(MainActivity.this,AllActivity.class);
                        startActivity(i5);
                        break;
                    case R.id.LogOut:
                        finish();
                        Intent i6=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(i6);
                    default:
                        return true;
                }


                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}