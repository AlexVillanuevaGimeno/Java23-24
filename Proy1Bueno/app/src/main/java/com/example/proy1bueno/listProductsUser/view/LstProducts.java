package com.example.proy1bueno.listProductsUser.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.proy1bueno.R;
import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.listProductsUser.ContractLstProduct;
import com.example.proy1bueno.listProductsUser.presenter.LstProductPresenter;
import com.example.proy1bueno.login_user.view.LoginUser;

import java.util.ArrayList;

public class LstProducts extends AppCompatActivity implements ContractLstProduct.View{
    Button returnButton;
    private LstProductPresenter presenter = new LstProductPresenter(this);

    private static LstProducts lstProducts = null;

    private static LstProducts getInstance(){
        if (lstProducts == null){
            lstProducts = new LstProducts();
        }
        return lstProducts;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_products);
        lstProducts = this;
        initComponents();
    }

    private void initComponents() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        Log.e("user_id","hello");
        Product product = new Product();
        presenter.lstProduct(product);
        returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginUser.class);
            startActivity(intent);
        });
    }

    @Override
    public void successLstProduct(ArrayList<Product> lstProducts) {

    }

    @Override
    public void failureLstProduct(String err) {

    }
}