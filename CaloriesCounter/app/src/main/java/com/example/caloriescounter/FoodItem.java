package com.example.caloriescounter;

public class FoodItem {

    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double carbs;

    // Конструктор
    public FoodItem(String name, double calories, double protein, double fat, double carbs) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbs() {
        return carbs;
    }
}
