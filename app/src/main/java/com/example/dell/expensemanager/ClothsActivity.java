package com.example.dell.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClothsActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView displayDate;
    Button changeDate,AddCloths;
    int month;

    DatabaseHelper myDb;
    EditText ClothsPr,ClothsNote;
    String SelectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloths);

        myDb = new DatabaseHelper(this);
        ClothsPr = (EditText)findViewById(R.id.ClothsPr);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        displayDate = (TextView) findViewById(R.id.display_date);
        displayDate.setText("Display Date");
        changeDate = (Button) findViewById(R.id.change_date_button);
        ClothsNote = (EditText)findViewById(R.id.ClothsNote);
        AddCloths = (Button)findViewById(R.id.AddCloths);
        AddCloths();
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
    public  void AddCloths() {
        AddCloths.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String NoteT = ClothsNote.getText().toString();
                        String PriceT = ClothsPr.getText().toString();
                        if (NoteT.isEmpty() && PriceT.isEmpty()) {
                            Toast.makeText(ClothsActivity.this, "All Fields Are Mandatry", Toast.LENGTH_LONG).show();
                        } else {
                            boolean isInserted = myDb.insertDataIntoClo(displayDate.getText().toString(), ClothsNote.getText().toString()
                                    , ClothsPr.getText().toString());
                            if (isInserted == true)
                                Toast.makeText(ClothsActivity.this, "Cloths Expense Added", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(ClothsActivity.this, "Cloths Expense Not Added ", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}