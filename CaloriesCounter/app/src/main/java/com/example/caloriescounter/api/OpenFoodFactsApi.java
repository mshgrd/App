package com.example.caloriescounter.api;

public interface OpenFoodFactsApi {
    @GET("v0/product/{barcode}.json")
    Call<Product> getProduct(@Path("barcode") String barcode);

    @GET("v0/search")
    Call<ProductListResponse> searchProducts(@Query("search_terms") String query);
}
