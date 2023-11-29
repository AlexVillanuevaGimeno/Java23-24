package com.example.proy1bueno.productFile.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.proy1bueno.IndexActivity;
import com.example.proy1bueno.R;
import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.categoriesFilter.view.Categories;
import com.example.proy1bueno.productFile.ContractProductFile;
import com.example.proy1bueno.productFile.presenter.ProductFilePresenter;
import com.example.proy1bueno.rate.view.Rate;
import com.google.android.material.button.MaterialButton;

public class ProductFile extends AppCompatActivity implements ContractProductFile.View {
    private TextView nombreTextView;
    private TextView precioTextView;
    private TextView marcaTextView;
    private TextView vendedorTextView;
    private TextView descripcionTextView;

    private MaterialButton btnRateSmall;
    private MaterialButton btnRateHuge;
    private int idProduct;

    private ProductFilePresenter productFilePresenter = new ProductFilePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_file);
        initComponents();
    }
    public void initComponents(){
        nombreTextView = findViewById(R.id.nombreProductFile);
        precioTextView = findViewById(R.id.precioProductFile);
        marcaTextView = findViewById(R.id.marcaProductFile);
        vendedorTextView = findViewById(R.id.vendedorProductFile);
        descripcionTextView = findViewById(R.id.descripcionProductFile);
        Product product = new Product();
         idProduct = getIntent().getIntExtra("idProduct", 0);
        product.setIdProducto(idProduct);
        productFilePresenter.productFile(product);
        btnRateSmall = findViewById(R.id.btnRateSmall);
        btnRateHuge = findViewById(R.id.btnRateHuge);
        btnRateSmall.setOnClickListener(v -> abrirRate());
        btnRateHuge.setOnClickListener(v -> abrirRate());
    }

    @Override
    public void succesProductFile(Product product) {
        // Aquí puedes imprimir los datos del producto
        Log.e("SUCCES FILE","LLEGO AL SUCCES PRINTO PRODUCT= "+ product);
        imprimirDatosProductoEncontrado(product);
    }

    @Override
    public void failureProductFile(String err) {
        // Aquí puedes manejar el fallo en la obtención del producto si es necesario
    }

    // Método para imprimir datos del producto
    private void imprimirDatosProductoEncontrado(Product product) {
        if (product != null) {
            Log.e("IMPRIMIR DATOS","Los datos son= " + product.toString());
            // Establecer datos en los TextViews con el producto
            nombreTextView.setText(product.getNombreProducto());
            precioTextView.setText(String.valueOf(product.getPrecioProducto())+"€");
            marcaTextView.setText(product.getMarcaProducto());
            vendedorTextView.setText(product.getVendedor());
            descripcionTextView.setText(product.getDescripcionProducto());
        }
    }

    public void abrirRate(){
        Intent intent = new Intent(this, Rate.class);
        intent.putExtra("idProduct", idProduct);
        startActivity(intent);
    }
}
