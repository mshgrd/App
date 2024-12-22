package com.example.caloriescounter.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FoodResponse {
    @SerializedName("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class Product {
        @SerializedName("product_name")
        private String productName;

        @SerializedName("code")
        private String code;

        @SerializedName("nutriments")
        private Nutriments nutriments;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Nutriments getNutriments() {
            return nutriments;
        }

        public void setNutriments(Nutriments nutriments) {
            this.nutriments = nutriments;
        }

        public static class Nutriments {
            @SerializedName("energy_100g")
            private float energy;

            @SerializedName("fat_100g")
            private float fat;

            @SerializedName("carbohydrates_100g")
            private float carbohydrates;

            @SerializedName("proteins_100g")
            private float proteins;

            public float getEnergy() {
                return energy;
            }

            public void setEnergy(float energy) {
                this.energy = energy;
            }

            public float getFat() {
                return fat;
            }

            public void setFat(float fat) {
                this.fat = fat;
            }

            public float getCarbohydrates() {
                return carbohydrates;
            }

            public void setCarbohydrates(float carbohydrates) {
                this.carbohydrates = carbohydrates;
            }

            public float getProteins() {
                return proteins;
            }

            public void setProteins(float proteins) {
                this.proteins = proteins;
            }
        }
    }
}
