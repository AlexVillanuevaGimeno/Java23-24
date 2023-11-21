package com.example.proy1bueno.listProductsUser.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.proy1bueno.R;
import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.listProductsUser.ContractLstProduct;
import com.example.proy1bueno.listProductsUser.presenter.LstProductPresenter;
import com.example.proy1bueno.login_user.view.LoginUser;

import java.util.ArrayList;

public class LstProducts extends AppCompatActivity implements ContractLstProduct.View{
    Button btnLogout;
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
        SharedPreferences UserPreferences = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        Log.e("user_id","id user preferences = " + UserPreferences);
        Product product = new Product();
        presenter.lstProduct(product);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = UserPreferences.edit();
            editor.remove("LogCheck");
            editor.remove("username");
            editor.remove("id");
            Log.e("Prefernces delete","borro credenciales" );
            editor.apply();
            Intent intent = new Intent(this, LoginUser.class);
            startActivity(intent);
        });
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    @Override
    public void successLstProduct(ArrayList<Product> lstProduct) {
        LinearLayout parentEl = null;

        for (Product product: lstProduct) {
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams parametrosLayout = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // Ancho ocupando el 100%
                    ViewGroup.LayoutParams.MATCH_PARENT  // Altura ajustada a match_parent
            );

            parametrosLayout.setMargins(0,dpToPx(5),0,0);
            linearLayout.setLayoutParams(parametrosLayout);
            linearLayout.setId(View.generateViewId());
            linearLayout.setGravity(Gravity.BOTTOM);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.my_primary));
            TextView textView = new TextView(this);
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(40)));
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setTextColor(ContextCompat.getColor(this, R.color.white));
            textView.setText(product.getNombreProducto() + product.getMarcaProducto() + "\n"
                                + product.getPrecioProducto());
            linearLayout.addView(textView);
            parentEl.addView(linearLayout);
        }
        }


    @Override
    public void failureLstProduct(String err) {

    }
}