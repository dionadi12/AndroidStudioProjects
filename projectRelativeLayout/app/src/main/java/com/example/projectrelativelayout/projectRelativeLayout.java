package com.example.projectrelativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Calendar;


public class projectRelativeLayout extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_relative_layout);
        tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText)findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
            //date picker dialog
            picker = new DatePickerDialog(projectRelativeLayout.this,
                                   new DatePickerDialog.OnDateSetListener() {
                                       public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                             int dayOfMonth) {
                                           eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                       }
                                   }, year, month, day);
            picker.show();
        }
        });
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("selected Date: "+ eText.getText());
            }
        });
    }
}