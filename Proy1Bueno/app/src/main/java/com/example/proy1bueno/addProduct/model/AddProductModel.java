package com.example.proy1bueno.addProduct.model;

import com.example.proy1bueno.addProduct.ContractAddProduct;
import com.example.proy1bueno.addProduct.presenter.AddProductPresenter;
import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.login_user.presenter.LoginUserPresenter;

public class AddProductModel implements  ContractAddProduct.Model{

    private static final String IP_BASE = "192.168.1.132:8088";
    private AddProductPresenter presenter;
    public AddProductModel(AddProductPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void addProductsApi(Product product, OnAddProductListener onAddProductListener) {

    }
}
