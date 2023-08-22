package com.example.makeuptask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeuptask.adapters.RVRetrofitAdapter;
import com.example.makeuptask.networking.ProductResult;
import com.example.makeuptask.networking.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRVProducts extends AppCompatActivity implements RVRetrofitAdapter.OnProductClickListener {
    RecyclerView rvProducts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_products);
        rvProducts = findViewById(R.id.rvProducts);

        getProducts();
    }
    private void getProducts() {

        Call<List<ProductResult>> apiCall = RetrofitClient.getInstance().getApis().getProducts("maybelline");
        apiCall.enqueue(new Callback<List<ProductResult>>() {
            @Override
            public void onResponse(Call<List<ProductResult>> call, Response<List<ProductResult>> response) {
                List<ProductResult> productResults = response.body();
                Toast.makeText(ActivityRVProducts.this, "Got Products", Toast.LENGTH_SHORT).show();
                setAdapter(productResults);
            }

            @Override
            public void onFailure(Call<List<ProductResult>> call, Throwable t) {
                Toast.makeText(ActivityRVProducts.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setAdapter(List<ProductResult> productResults) {
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        RVRetrofitAdapter rvRetrofitAdapter = new RVRetrofitAdapter(this, productResults, this);
        rvProducts.setAdapter(rvRetrofitAdapter);
    }
    @Override
    public void onProductClick(ProductResult product) {
        Intent intent = new Intent(this, DetaljiActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}
