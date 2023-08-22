package com.example.makeuptask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.makeuptask.networking.ProductResult;

public class DetaljiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        ImageView ivProductImage = findViewById(R.id.ivProductImage);
        TextView tvProductName = findViewById(R.id.tvProductName);
        TextView tvPrice = findViewById(R.id.tvPrice);

        ProductResult product = (ProductResult) getIntent().getParcelableExtra("product");
        if (product != null) {
            Log.d("DetaljiActivity", "Product name: " + product.getName());
            Log.d("DetaljiActivity", "Product price: " + product.getPrice());
            Log.d("DetaljiActivity", "Product image link: " + product.getImage_link());

            tvProductName.setText(product.getName());
            tvPrice.setText(product.getPrice());
            Glide.with(this).load(product.getImage_link()).into(ivProductImage);
        } else {
            Log.e("DetaljiActivity", "Product is null");
        }
    }
}
