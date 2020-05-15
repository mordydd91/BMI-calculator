//Author:    Mordy dabah

package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private ImageView ivBMI;
    private TextView tvBMI, tvRate, tvEpx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        float bmi = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            bmi = extras.getFloat("BMI");
            //The key argument here must match that used in the other activity
        }

        //take over
        ivBMI = findViewById(R.id.iv_result);
        tvBMI = findViewById(R.id.tvBMI_result);
        tvRate = findViewById(R.id.tvRate);
        tvEpx = findViewById(R.id.tvExplain);

        //show BMI

        if (bmi <= 18.5) {
            ivBMI.setImageResource(R.drawable.bmi1);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Underweight range.");
            tvEpx.setText("you're a bit underweight and can't afford to lose more.");
        }else if (bmi <= 24.9) {
            ivBMI.setImageResource(R.drawable.bmi2);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Healthy Weight range.");
            tvEpx.setText("Maintaining a healthy weight may reduce the risk of chronic diseases associated with overweight and obesity.");
        }else if (bmi <= 29.9) {
            ivBMI.setImageResource(R.drawable.bmi3);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Overweight range.");
            tvEpx.setText("People who are overweight or obese are at higher risk for chronic conditions such as high blood pressure, diabetes, and high cholesterol.");
        }else if (bmi <= 34.9) {
            ivBMI.setImageResource(R.drawable.bmi4);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Obese I range.");
            tvEpx.setText("People who are overweight or obese are at higher risk for chronic conditions such as high blood pressure, diabetes, and high cholesterol.");
        }else if (bmi <= 39.9) {
            ivBMI.setImageResource(R.drawable.bmi5);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Obese II range.");
            tvEpx.setText("People who are overweight or obese are at higher risk for chronic conditions such as high blood pressure, diabetes, and high cholesterol.");
        } else {
            ivBMI.setImageResource(R.drawable.bmi6);
            tvBMI.setText("your BMI is " +bmi);
            tvRate.setText("You are in the Obese III range.");
            tvEpx.setText("People who are overweight or obese are at higher risk for chronic conditions such as high blood pressure, diabetes, and high cholesterol.");
        }


    }


}

