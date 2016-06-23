package com.example.kshah97.nytimessearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.kshah97.nytimessearch.R;

import java.util.ArrayList;

public class AdvancedSearch extends AppCompatActivity {

    String begin_date;
    String sort;
    ArrayList<String> news_desk_values = new ArrayList();


    public String getBegin_date() {
        return begin_date;
    }

    public String getSort() {
        return sort;
    }

    public ArrayList<String> getNews_desk_values() {
        return news_desk_values;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);


        Spinner spinner = (Spinner) findViewById(R.id.spSortOrder);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_drop_down, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sort = parent.getItemAtPosition(position).toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

    }




    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cbArts:
                if (checked)
                // Put some meat on the sandwich

                this.news_desk_values.add("Arts");


                break;
            case R.id.cbFashion:
                if (checked)
                // Cheese me
                    this.news_desk_values.add("Fashion and Style");

                break;

            case R.id.cbSports:
                if (checked)
                // Cheese me
                    this.news_desk_values.add("Sports");

                break;

        }
    }

    public void onSaveClick(View view) {


        EditText etDate = (EditText) findViewById(R.id.etDate);
        this.begin_date = etDate.getText().toString();



        Intent data = new Intent();
        data.putExtra("begin_date", begin_date);
        data.putExtra("news_desk_values", news_desk_values);
        data.putExtra("sort", sort);

        setResult(RESULT_OK, data);

        finish();

    }


}
