package com.example.caloriescounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.caloriescounter.model.Food;
import com.example.caloriescounter.model.Meal;
import java.util.ArrayList;
import java.util.List;

public class MealHistoryActivity extends AppCompatActivity {
    private Button btnAddMeal;
    private RecyclerView recyclerView;
    private MealAdapter mealAdapter;
    private TextView textCalories, textProteins, textFats, textCarbs;

    private List<Meal> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_history);

        btnAddMeal = findViewById(R.id.btnAddMeal);
        recyclerView = findViewById(R.id.recyclerView);
        textCalories = findViewById(R.id.textCalories);
        textProteins = findViewById(R.id.textProteins);
        textFats = findViewById(R.id.textFats);
        textCarbs = findViewById(R.id.textCarbs);

        mealAdapter = new MealAdapter(mealList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mealAdapter);

        btnAddMeal.setOnClickListener(v -> openAddFoodActivity());
    }

    private void openAddFoodActivity() {
        Intent intent = new Intent(MealHistoryActivity.this, AddFoodActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Food food = (Food) data.getSerializableExtra("food");
            if (food != null) {
                addFoodToMeal(food);
            }
        }
    }

    private void addFoodToMeal(Food food) {
        Meal meal = new Meal(food.getName(), food.getCalories(), food.getProteins(), food.getFats(), food.getCarbs());
        mealList.add(meal);
        mealAdapter.notifyDataSetChanged();
        updateDailyTotal();
    }

    private void updateDailyTotal() {
        double totalCalories = 0;
        double totalProteins = 0;
        double totalFats = 0;
        double totalCarbs = 0;

        for (Meal meal : mealList) {
            totalCalories += meal.getCalories();
            totalProteins += meal.getProteins();
            totalFats += meal.getFats();
            totalCarbs += meal.getCarbs();
        }

        textCalories.setText("Calories: " + totalCalories);
        textProteins.setText("Proteins: " + totalProteins);
        textFats.setText("Fats: " + totalFats);
        textCarbs.setText("Carbs: " + totalCarbs);
    }
}
