package com.example.dell.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EntertainmentActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView displayDate;
    Button changeDate,AddEntertainment;
    int month;

    DatabaseHelper myDb;
    EditText EntertainmentPr,EntertainmentNote;
    String SelectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

        myDb = new DatabaseHelper(this);
        EntertainmentPr = (EditText)findViewById(R.id.EntertainmentPr);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        displayDate = (TextView) findViewById(R.id.display_date);
        displayDate.setText("Display Date");
        changeDate = (Button) findViewById(R.id.change_date_button);
        EntertainmentNote = (EditText)findViewById(R.id.EntertainmentNote);
        AddEntertainment = (Button)findViewById(R.id.AddEntertainment);
        AddEntertainment();
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
    public  void AddEntertainment() {
        AddEntertainment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String NoteT = EntertainmentNote.getText().toString();
                        String PriceT = EntertainmentPr.getText().toString();
                        if (NoteT.isEmpty() && PriceT.isEmpty()) {
                            Toast.makeText(EntertainmentActivity.this, "All Fields Are Mandatry", Toast.LENGTH_LONG).show();
                        } else {
                            boolean isInserted = myDb.insertDataIntoEnt(displayDate.getText().toString(), EntertainmentNote.getText().toString()
                                    , EntertainmentPr.getText().toString());
                            if (isInserted == true)
                                Toast.makeText(EntertainmentActivity.this, "Entertainment Expense Added", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(EntertainmentActivity.this, "Entertainment Expense Not Added ", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}