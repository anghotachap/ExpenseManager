package com.example.dell.expensemanager;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView displayDate;
    Button changeDate,AddHome;
    int month;

    DatabaseHelper myDb;
    EditText HomePr,HomeNote;
    String SelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myDb = new DatabaseHelper(this);
        HomePr = (EditText)findViewById(R.id.HomePr);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        displayDate = (TextView) findViewById(R.id.display_date);
        displayDate.setText("Display Date");
        changeDate = (Button) findViewById(R.id.change_date_button);
        HomeNote = (EditText)findViewById(R.id.HomeNote);
        AddHome = (Button)findViewById(R.id.AddHome);
        AddHome();
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
    public  void AddHome() {
        AddHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertDataIntoHome(displayDate.getText().toString(),HomeNote.getText().toString()
                                , HomePr.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(HomeActivity.this,"Home Expense Added",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(HomeActivity.this,"Home Expense Not Added ",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}