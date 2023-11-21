package com.example.proy1bueno.addProduct.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.proy1bueno.R;
import com.example.proy1bueno.listProductsUser.view.LstProducts;

public class AddProduct extends AppCompatActivity {
    Button btnRetunProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        initComponents();

    }
    public void initComponents(){
        btnRetunProducts = findViewById(R.id.btnRetunProducts);
        btnRetunProducts.setOnClickListener(view -> {
            Intent intent = new Intent(this, LstProducts.class);
            startActivity(intent);
        });
    }
}