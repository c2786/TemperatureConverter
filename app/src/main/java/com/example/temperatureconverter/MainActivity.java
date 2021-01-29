package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView Res;
    String result="";
    RadioGroup unit;
    EditText enter;
    double f,c = 0.0;
    String F,C = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit = findViewById(R.id.unit);
        enter = findViewById(R.id.editText_enter);
    }

    public void showResult(View view)
    {
        if (unit.getCheckedRadioButtonId() == R.id.radioButton_FtoC)
        {
            if (enter.getText().toString().length() == 0)
                result = "Please Enter Again!";
            else
            {
                f = Double.parseDouble(enter.getText().toString());
                c = (f - 32) * 5 / 9;
                C = String.format("%.2f", c);
                result = "";
                result = enter.getText().toString() + " (°F) → " + C + " (°C)";
            }

        }
        else if (unit.getCheckedRadioButtonId() == R.id.radioButton_CtoF)
        {
            if (enter.getText().toString().length() == 0)
                result = "Please Enter Again!";
            else {
                c = Double.parseDouble(enter.getText().toString());
                f = c * 9 / 5 + 32;
                F = String.format("%.2f", f);
                result = "";
                result = enter.getText().toString() + " (°C) → " + F + " (°F)";
            }
        }
        else
        {
            result = "Please select which conversion you want to calculate!";
        }
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void setClear(View view)
    {
        ((RadioGroup)unit).clearCheck();
        EditText Enter = findViewById(R.id.editText_enter);
        Enter.setText("");
    }
    public void showGuide(View view)
    {
        Toast toast = Toast.makeText(this, "The App has a way of selecting  Fahrenheit to Celsius vs  Celsius to Fahrenheit conversion", Toast.LENGTH_SHORT);
        toast.show();
    }
}
