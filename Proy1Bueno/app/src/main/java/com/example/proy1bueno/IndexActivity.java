package com.example.proy1bueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.proy1bueno.categoriesFilter.view.Categories;
import com.example.proy1bueno.historicalPurchases.view.HistoricalPurchases;
import com.example.proy1bueno.listProductsUser.view.LstProducts;
import com.example.proy1bueno.lstBetterRates.view.LstBetterRates;
import com.example.proy1bueno.userFilter.view.UserFilter;

public class IndexActivity extends AppCompatActivity {
    Button btnCatalogo;
    Button btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnLogOut = findViewById(R.id.btnLogOut);
        ImageButton btnHomeFooter = findViewById(R.id.btnHomeFooter);
        ImageButton btnBetterRates = findViewById(R.id.btnBetterRates);
        ImageButton btnProfile = findViewById(R.id.btnProfile);
        ImageButton btnMostSells = findViewById(R.id.btnMostSells);
        ImageButton btnBuys = findViewById(R.id.btnBuys);
        btnCatalogo.setOnClickListener(v -> abrirProductsCategory());
        btnLogOut.setOnClickListener(v -> logOut());
        btnHomeFooter.setOnClickListener(v -> volverHome());
        btnBetterRates.setOnClickListener(v -> abrirValoraciones());
        btnProfile.setOnClickListener(v -> abrirMisProductos());
        btnMostSells.setOnClickListener(v -> abrirUsuarioVentas());
        btnBuys.setOnClickListener(v -> abrirHistoricoCompras());

    }

    private void volverHome(){
        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);
    }
    private void abrirValoraciones(){
        Intent intent = new Intent(this, LstBetterRates.class);
        startActivity(intent);
    }

    private void abrirUsuarioVentas(){
        Intent intent = new Intent(this, UserFilter.class);
        startActivity(intent);
    }
    private void abrirHistoricoCompras(){
        Intent intent = new Intent(this, HistoricalPurchases.class);
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