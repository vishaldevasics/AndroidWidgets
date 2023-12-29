package com.maverickallies.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DatePickerAndProgressBar extends AppCompatActivity {
    DatePicker datePicker;
    Button btn,progBarBtn;
    ProgressBar progressBar;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_progress_bar);

        btn = findViewById(R.id.selectBtnID);
        datePicker = findViewById(R.id.datePickerID);
        progressBar = findViewById(R.id.progBarID);
        progBarBtn = findViewById(R.id.progBtnID);

        progBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress + 10;

                progressBar.setProgress(progress);

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day " + datePicker.getDayOfMonth();
                String month = "Month " + (datePicker.getMonth()+1);
                String year = "Year " + datePicker.getYear();

                Toast.makeText(DatePickerAndProgressBar.this,
                        day +" "+ month +" "+ year,
                        Toast.LENGTH_SHORT).show();

            }
        });


    }
}