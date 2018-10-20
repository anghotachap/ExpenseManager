package com.example.dell.expensemanager;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTravellingActivity extends AppCompatActivity {
    Button AddTravelling,ViewTravelling;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travelling);
        myDb = new DatabaseHelper(this);
        ViewTravelling=(Button)findViewById(R.id.ViewTravelling);
        ViewTravelling();
        AddTravelling=findViewById(R.id.AddTravelling);
        AddTravelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(AddTravellingActivity.this,TravellingActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public void ViewTravelling() {
        ViewTravelling.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllTravelData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Spend More !","No Expense records found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("TID :"+ res.getString(0)+"\n");
                            buffer.append(""+ res.getString(1)+"\n");
                            buffer.append("NOTE :"+ res.getString(2)+"\n");
                            buffer.append("AMOUNT :"+ res.getString(3)+"\n\n");

                        }

                        // Show all data
                        showMessage("Expense Records",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
