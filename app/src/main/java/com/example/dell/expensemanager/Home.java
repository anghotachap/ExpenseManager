package com.example.dell.expensemanager;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Home extends Fragment {
    CardView Home,Entertainment,Cloths,Travelling,Sports;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView = inflater.inflate(R.layout.home, container, false);
        Home=(CardView)rootView.findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(getActivity(),AddHomeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Entertainment=(CardView)rootView.findViewById(R.id.Entertainment);
        Entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(getActivity(),AddEntertainmentActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Cloths=(CardView)rootView.findViewById(R.id.Cloths);
        Cloths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(getActivity(),AddClothsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Travelling=(CardView)rootView.findViewById(R.id.Travelling);
        Travelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(getActivity(),AddTravellingActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        Sports=(CardView)rootView.findViewById(R.id.Sports);
        Sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(getActivity(),AddSportsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        return rootView;



    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");
    }
}