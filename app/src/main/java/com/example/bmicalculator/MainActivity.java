//Author:    Mordy dabah


package com.example.bmicalculator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etW, etH;
    private Button btnCompute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Take over
        etW = findViewById(R.id.etW);
        etH = findViewById(R.id.etH);
        btnCompute = findViewById(R.id.btnCompute);

        //listener
        btnCompute.setOnClickListener(this);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        etW.setText(null);
        etH.setText(null);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCompute) {
            //בדיקות קלט
            String heightStr, weightStr;
            float height = 0, weight = 0;
            heightStr = etH.getText().toString();
            weightStr = etW.getText().toString();

            int flag = 0;
            //test weight
            if (weightStr.isEmpty()) {
                etW.setError("Cannot be empty");
                etW.requestFocus();
                flag = 1;
            } else {
                try {
                    weight = Float.parseFloat(weightStr);
                } catch (Exception e) {
                    etW.setError("Only valid numbers");
                    etW.requestFocus();
                    flag = 1;
                }
                if (weight==0){
                    etW.setError("Weight cannot be zero");
                    etW.requestFocus();
                    flag = 1;
                }
            }

            //test height
            if (heightStr.isEmpty()) {
                etH.setError("Cannot be empty");
                etH.requestFocus();
                flag = 1;
            } else {
                try {
                    height = Float.parseFloat(heightStr);
                } catch (Exception e) {
                    etH.setError("Only valid numbers");
                    etH.requestFocus();
                    flag = 1;
                }
                if (height==0){
                    etH.setError("Height cannot be zero");
                    etH.requestFocus();
                    flag = 1;
                }
            }
            //test bmi
            if (flag == 1)
                return;
            else {
                // calculate the BMI
                float bmi = weight / (height * height);
                Intent intent = new Intent(this, Result.class);
                intent.putExtra("BMI", bmi);
                startActivity(intent);
            }
        }

    }
}
