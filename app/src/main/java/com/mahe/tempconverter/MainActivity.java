package com.mahe.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button ansBtn,againBtn;
    TextView showAns;
    EditText getVal;
    RadioButton cTOf,fTOc;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansbtn);
        showAns = (TextView) findViewById(R.id.showans);
        getVal = (EditText) findViewById(R.id.getval);
        cTOf = (RadioButton) findViewById(R.id.CtoF);
        fTOc = (RadioButton) findViewById(R.id.FtoC);
        againBtn = (Button) findViewById(R.id.againbtn);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getVal.getText().toString().isEmpty()){
                    showAns.setText("Please Enter Temperature");
                }
                else{

                    x = Double.parseDouble(String.valueOf(getVal.getText()));

                    if(cTOf.isChecked()){
                        x = (x*9)/5+32;
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(String.valueOf(x) + " Degree F");
                    }
                    else if(fTOc.isChecked()){
                        x = (x-32)*5/9;
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(String.valueOf(x) + " Degree C");
                    }
                    else{
                        showAns.setText("Please select an option!");
                    }
                }
            }
        });
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("0.0");
                getVal.setText("");
                cTOf.setChecked(false);
                fTOc.setChecked(false);
            }
        });

    }
}