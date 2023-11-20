package com.example.proy1bueno.listProductsUser.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.listProductsUser.ContractLstProduct;
import com.example.proy1bueno.listProductsUser.data.DataProduct;
import com.example.proy1bueno.listProductsUser.presenter.LstProductPresenter;
import com.example.proy1bueno.login_user.data.DataUser;
import com.example.proy1bueno.utils.ApiService;
import com.example.proy1bueno.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LstProductModel extends AppCompatActivity implements ContractLstProduct.Model{
    private SharedPreferences sharedPreferencesUserCFG;
    private Context context;

    private static final String IP_BASE = "192.168.1.132:8088";
    private LstProductPresenter presenter;

//   public LstProductModel(Context context){
//        this.context = context;
//   }
    public LstProductModel(LstProductPresenter presenter, Context context){
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void lstAPI(Product product, OnLstProductListener onLstProductListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        Log.e("Apiservice","Apiservice" + apiService);
        sharedPreferencesUserCFG = context.getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        Call<DataProduct> call;
//        if (sharedPreferencesUserCFG.getInt("id",0) == 0){
//            call = apiService.getDataProductList("PRODUCT.FILTER");
//        }else{
//            call = apiService.getDataProductList("PRODUCT.FILTER", sharedPreferencesUserCFG.getInt("id",0));
//        }

        call = apiService.getDataProductList("PRODUCT.LST");
        Log.e("call","call" + call);
        call.enqueue(new Callback<DataProduct>() {

            @Override
            public void onResponse(Call<DataProduct> call, Response<DataProduct> response) {
                if (response.isSuccessful()) {
                    DataProduct dataProduct = response.body();
                    ArrayList<Product> lstProducts = dataProduct.getLstProducts();
                    onLstProductListener.onFinished(lstProducts);


                }
            }

            @Override
            public void onFailure(Call<DataProduct> call, Throwable t) {

            }
        });
        }
}
