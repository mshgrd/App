package com.example.caloriescounter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.caloriescounter.model.Meal;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Meal> mealList;

    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.foodName.setText(meal.getFoodName());
        holder.calories.setText("Calories: " + meal.getCalories());
        holder.proteins.setText("Proteins: " + meal.getProteins());
        holder.fats.setText("Fats: " + meal.getFats());
        holder.carbs.setText("Carbs: " + meal.getCarbs());
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, calories, proteins, fats, carbs;

        public MealViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            calories = itemView.findViewById(R.id.calories);
            proteins = itemView.findViewById(R.id.proteins);
            fats = itemView.findViewById(R.id.fats);
            carbs = itemView.findViewById(R.id.carbs);
        }
    }
}
