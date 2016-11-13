/* Calculator app.
* @author: Emmanuel Boye
* @version: Fall 2016
*
 */

package com.example.franksowah.homework02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Calculator extends AppCompatActivity implements View.OnClickListener, OnItemSelectedListener {

    private EditText inputNum1;
    private EditText inputNum2;
    private Spinner spinner;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //init method to initalize instance variables
        init();
    }
    //method to initialize instance variables
    private void init() {
        inputNum1 = (EditText) findViewById(R.id.inputNum1);
        inputNum2 = (EditText) findViewById(R.id.inputNum2);
        spinner = (Spinner) findViewById(R.id.spinner);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        spinner.setOnItemSelectedListener(this);

        calculate.setOnClickListener(this);

        // Spinner Drop down elements add to List
        List<String> categories = new ArrayList<String>();
        categories.add("+");
        categories.add("-");
        categories.add("*");
        categories.add("/");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    //method that causes button to do an action when clicked
    @Override
    public void onClick(View v) {
        //get input values
        String num1 = inputNum1.getText().toString();
        String num2 = inputNum2.getText().toString();
        //get selected item from spinner
        String value = spinner.getSelectedItem().toString();

        switch (v.getId()) {
            case R.id.calculate:
                if (value == "+") {
                    int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
                if (value == "-") {
                    int addition = Integer.parseInt(num1) - Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
                if (value == "*") {
                    int addition = Integer.parseInt(num1) * Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
                if (value == "/") {
                    int addition = Integer.parseInt(num1) / Integer.parseInt(num2);
                    result.setText(String.valueOf(addition));
                }
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
