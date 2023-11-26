package com.example.proy1bueno.lstBetterRates.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.proy1bueno.MainActivity;
import com.example.proy1bueno.R;
import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.beans.Valoracion;
import com.example.proy1bueno.lstBetterRates.ContractLstBetterRates;
import com.example.proy1bueno.lstBetterRates.presenter.LstBetterRatesPresenter;



import java.util.ArrayList;

public class LstBetterRates extends AppCompatActivity implements ContractLstBetterRates.View{
    private ImageButton btnHome;


    private LstBetterRatesPresenter presenter = new LstBetterRatesPresenter(this);
    private static LstBetterRates lstBetterRates = null;

    private static LstBetterRates getInstance(){
        if (lstBetterRates == null){
            lstBetterRates = new LstBetterRates();
        }
        return lstBetterRates;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_better_rates);
        lstBetterRates = this;
        initComponents();
    }

    private void initComponents() {
        Valoracion valoracion = new Valoracion();
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        presenter.lstBetterRates(valoracion);
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    @Override
    public void succesLstBetterRates(ArrayList<Valoracion> lstValoraciones) {
        LinearLayout productsColumn = findViewById(R.id.productsColumn);
        LinearLayout parentEl = null;

        for (Valoracion valoracion : lstValoraciones) {
            Log.e("ForEach Succes","Usuario = " + valoracion);
            parentEl = productsColumn;
            Log.e("SuccesList", "ProductForEach" + valoracion.toString());
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams parametrosLayout = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // Ancho ocupando el 100%
                    ViewGroup.LayoutParams.WRAP_CONTENT  // Altura ajustada a Wrap-content
            );
            parametrosLayout.setMargins(0,dpToPx(5),0,0);
            linearLayout.setLayoutParams(parametrosLayout);
            linearLayout.setId(View.generateViewId());
            linearLayout.setGravity(Gravity.TOP);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.my_primary));
            TextView textView = new TextView(this);
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(40)));
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setTextColor(ContextCompat.getColor(this, R.color.black));
            textView.setText(valoracion.getIdProduct() + " " + valoracion.getNombreProducto() + "\n" + "Puntuaje medio del producto" + valoracion.getPromedioValoracion());
            linearLayout.addView(textView);
            Log.e("listaPRODUCCTOS","LSIADO: " + valoracion.getIdProduct() + valoracion.getNombreProducto() + "\n" + valoracion.getPromedioValoracion());
            parentEl.addView(linearLayout);
        }
    }

    @Override
    public void failureLstBetterRates(String err) {

    }
}