package com.example.caloriescounter;

public class Product {
    private String product_name;
    private Nutrients nutrients;

    public class Nutrients {
        private double proteins_100g;
        private double fat_100g;
        private double carbohydrates_100g;

        public double getProteins() {
            return proteins_100g;
        }

        public double getFat() {
            return fat_100g;
        }

        public double getCarbohydrates() {
            return carbohydrates_100g;
        }
    }

    public String getProductName() {
        return product_name;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }
}
