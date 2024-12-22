package com.example.caloriescounter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.caloriescounter.model.Food;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getName());
        holder.calories.setText("Calories: " + food.getCalories());
        holder.proteins.setText("Proteins: " + food.getProteins());
        holder.fats.setText("Fats: " + food.getFats());
        holder.carbs.setText("Carbs: " + food.getCarbs());
    }

    @Override
    public int getItemCount() {
        return foodList != null ? foodList.size() : 0;
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, calories, proteins, fats, carbs;

        public FoodViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            calories = itemView.findViewById(R.id.calories);
            proteins = itemView.findViewById(R.id.proteins);
            fats = itemView.findViewById(R.id.fats);
            carbs = itemView.findViewById(R.id.carbs);
        }
    }
}
