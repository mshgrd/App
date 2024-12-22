package com.example.caloriescounter;

public class BMRCalculator {

    private double weight;
    private double height;
    private int age;

    // Конструктор для инициализации данных
    public BMRCalculator(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    // Формула расчета BMR (для мужчин) — для женщин нужно изменить на -161
    public double calculateBMR() {
        return 10 * weight + 6.25 * height - 5 * age + 5;
    }
}
