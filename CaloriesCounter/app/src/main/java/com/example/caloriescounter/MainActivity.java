package com.example.caloriescounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editWeight, editHeight, editAge;
    private Button btnCalculate, btnViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        editAge = findViewById(R.id.editAge);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnViewHistory = findViewById(R.id.btnViewHistory);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = editWeight.getText().toString();
                String heightStr = editHeight.getText().toString();
                String ageStr = editAge.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty()) {
                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr);
                    int age = Integer.parseInt(ageStr);

                    double bmr = 66.5 + (13.75 * weight) + (5 * height) - (6.75 * age);
                    Toast.makeText(MainActivity.this, "Your BMR: " + bmr + " kcal/day", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MealHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
