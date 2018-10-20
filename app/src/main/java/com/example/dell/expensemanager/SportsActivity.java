package com.example.dell.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SportsActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView displayDate;
    Button changeDate,AddSports;
    int month;

    DatabaseHelper myDb;
    EditText SportsPr,SportsNote;
    String SelectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        myDb = new DatabaseHelper(this);
        SportsPr = (EditText)findViewById(R.id.SportsPr);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        displayDate = (TextView) findViewById(R.id.display_date);
        displayDate.setText("Display Date");
        changeDate = (Button) findViewById(R.id.change_date_button);
        SportsNote = (EditText)findViewById(R.id.SportsNote);
        AddSports = (Button)findViewById(R.id.AddSports);
        AddSports();
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
    public  void AddSports() {
        AddSports.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertDataIntoSport(displayDate.getText().toString(),SportsNote.getText().toString()
                                , SportsPr.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(SportsActivity.this,"Sports Expense Added",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SportsActivity.this,"Sports Expense Not Added ",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}