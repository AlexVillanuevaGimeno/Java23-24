package com.example.proy1bueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.proy1bueno.categoriesFilter.view.Categories;
import com.example.proy1bueno.listProductsUser.view.LstProducts;
import com.example.proy1bueno.lstBetterRates.view.LstBetterRates;
import com.example.proy1bueno.userFilter.view.UserFilter;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnUserSells = findViewById(R.id.btnUserSells);
        Button btnBetterRateProducts = findViewById(R.id.btnBetterRateProducts);
        Button btnProductCategory = findViewById(R.id.btnProductsCategory);
        Button btnMyProducts = findViewById(R.id.btnMisproductos);
        btnBetterRateProducts.setOnClickListener(v -> abrirValoraciones());
        btnUserSells.setOnClickListener(v -> abrirUsuarioVentas());
        btnProductCategory.setOnClickListener(v -> abrirProductsCategory());
        btnMyProducts.setOnClickListener(v -> abrirMisProductos());
    }

    private void abrirValoraciones(){
        Intent intent = new Intent(this, LstBetterRates.class);
        startActivity(intent);
    }

    private void abrirUsuarioVentas(){
        Intent intent = new Intent(this, UserFilter.class);
        startActivity(intent);
    }

    private void abrirProductsCategory(){
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }
    private void abrirMisProductos(){
        Intent intent = new Intent(this, LstProducts.class);
        startActivity(intent);
    }

    private void logOut(){
        SharedPreferences UserPreferences = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = UserPreferences.edit();
        editor.remove("LogCheck");
        editor.remove("username");
        editor.remove("idUser");
        Log.e("Preferences delete","borro credenciales" );
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}