package com.example.caloriescounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.caloriescounter.model.Food;
import com.example.caloriescounter.model.FoodResponse;
import com.example.caloriescounter.network.ApiClient;
import com.example.caloriescounter.network.ApiService;
import java.util.List;

public class AddFoodActivity extends AppCompatActivity {
    private EditText editFoodName;
    private Button btnSearch;
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        editFoodName = findViewById(R.id.editFoodName);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodAdapter = new FoodAdapter();
        recyclerView.setAdapter(foodAdapter);

        btnSearch.setOnClickListener(v -> searchFood());
    }

    private void searchFood() {
        String query = editFoodName.getText().toString();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a food name", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<FoodResponse> call = apiService.searchFood(query);
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Food> foods = response.body().getFoods();
                    foodAdapter.setFoodList(foods);
                } else {
                    Toast.makeText(AddFoodActivity.this, "No foods found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Toast.makeText(AddFoodActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Функция для добавления выбранного продукта в историю приема пищи
    public void addSelectedFood(Food food) {
        Intent intent = new Intent();
        intent.putExtra("food", food);
        setResult(RESULT_OK, intent);
        finish();
    }
}
