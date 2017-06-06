package com.example.techgenysis.myapplication103;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner S;
    TextView T;
    Button btn;
    String text1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        S = (Spinner) findViewById(R.id.spinner);
        T = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.songs, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        S.setAdapter(adapter);
        S.setOnItemSelectedListener(new YourItemSelectedListener());
    }

    public class YourItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


            text1 = parent.getItemAtPosition(pos).toString();

            // YourItemSelectedListener y = new YourItemSelectedListener();
            //y.onItemSelected();

        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
    public void Clicked(View v) {
        if(text1.equals("Select an option"))
        {
            Context context = getApplicationContext();
            String text = "Select your choice!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }
        else
            T.setText(text1);
    }
}