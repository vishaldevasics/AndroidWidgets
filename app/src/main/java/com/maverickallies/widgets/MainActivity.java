package com.maverickallies.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;
    TimePicker timePicker;
    Button nextPageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox);
        radioGroup = findViewById(R.id.radioGroupID);
        spinner = findViewById(R.id.spinnerID);
        timePicker = findViewById(R.id.timepickerID);
        nextPageBtn = findViewById(R.id.btnID);


        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });




        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //Handle time change
                Toast.makeText(MainActivity.this, "Hour : "+hourOfDay+" minute : "+ minute, Toast.LENGTH_SHORT).show();
            }
        });




        String[] courses = {"math","Physics","Chemistry","Python"};

        // ArrayAdapter : used to populate the 'Spinner' with
//                        items from the string array resource

        // Three parameters are passed to the ArrayAdapter method.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,courses);

        spinner.setAdapter(adapter);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this,"You choose "+radioButton.getText().toString() ,Toast.LENGTH_SHORT).show();
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Toast.makeText(MainActivity.this, "Checkbox is checked.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Checkbox is not checked.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    public void nextPage(){
        Intent intent = new Intent(this,DatePickerAndProgressBar.class);
        startActivity(intent);
    }
}