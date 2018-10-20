package com.example.dell.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TravellingActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView displayDate;
    Button changeDate,AddTravelling;
    int month;

    DatabaseHelper myDb;
    EditText TravellingPr,TravellingNote;
    String SelectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelling);

        myDb = new DatabaseHelper(this);
        TravellingPr = (EditText)findViewById(R.id.TravellingPr);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        displayDate = (TextView) findViewById(R.id.display_date);
        displayDate.setText("Display Date");
        changeDate = (Button) findViewById(R.id.change_date_button);
        TravellingNote = (EditText)findViewById(R.id.TravellingNote);
        AddTravelling = (Button)findViewById(R.id.AddTravelling);
        AddTravelling();
        SelectDate();
    }
    public String currentDate() {
        StringBuilder mcurrentDate = new StringBuilder();
        month = datePicker.getMonth() + 1;
        mcurrentDate.append("Date: " + datePicker.getDayOfMonth() + "/" +  month+ "/" + datePicker.getYear());
        SelectedDate =mcurrentDate.toString();
        return mcurrentDate.toString();
    }
    public void SelectDate()
    {
        displayDate.setText(currentDate());
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDate.setText(currentDate());
            }
        });

    }
    public  void AddTravelling() {
        AddTravelling.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertDataIntoTravel(displayDate.getText().toString(),TravellingNote.getText().toString()
                                , TravellingPr.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(TravellingActivity.this,"Travelling Expense Added",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(TravellingActivity.this,"Travelling Expense Not Added ",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}