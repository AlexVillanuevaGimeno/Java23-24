package com.example.proy1bueno.addCompra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proy1bueno.R;
import com.example.proy1bueno.addCompra.ContractAddCompra;
import com.example.proy1bueno.addCompra.presenter.AddCompraPresenter;
import com.example.proy1bueno.addProduct.presenter.AddProductPresenter;
import com.example.proy1bueno.beans.Compra;
import com.example.proy1bueno.beans.Valoracion;
import com.example.proy1bueno.categoriesFilter.view.Categories;

public class AddCompra extends AppCompatActivity implements ContractAddCompra.View{
    SharedPreferences sharedPreferencesUserCFG;
    int idUserCompra;
    int idProductCompra;
    Button btnComprar;
    private ImageButton btnHome;

    private AddCompraPresenter presenter = new AddCompraPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compra);
        initComponents();
    }

    public void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        idUserCompra = sharedPreferencesUserCFG.getInt("idUser",0);
        Log.e("user_id","id user preferences = " + idUserCompra);
        idProductCompra = getIntent().getIntExtra("idProduct",0);
        Log.e("idProduct","id producto comprar = " + idProductCompra);

        btnHome = findViewById(R.id.btnHome);
        btnComprar = findViewById(R.id.btnComprar);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(this, Categories.class);
            startActivity(intent);
        });
        btnComprar.setOnClickListener(view->{
            Compra compra = new Compra();
            compra.setIdComprador(idUserCompra);
            compra.setIdProductoComprado(idProductCompra);
            Toast.makeText(this, compra.toString(), Toast.LENGTH_SHORT).show();
            presenter.addCompra(compra);
            Toast.makeText(this,"COMPRA CONFIRMADA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Categories.class);
            startActivity(intent);
        });
    }

    @Override
    public void successAddCompra(Compra compra) {

    }

    @Override
    public void failureAddCompra(String err) {

    }
}