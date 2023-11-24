package com.example.proy1bueno.userFilter.view;

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
import com.example.proy1bueno.beans.Product;
import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.userFilter.ContractUserFilter;
import com.example.proy1bueno.userFilter.presenter.UserFilterPresenter;

import java.util.ArrayList;

public class UserFilter extends AppCompatActivity implements ContractUserFilter.View{
    private ImageButton btnHome;


    private UserFilterPresenter presenter = new UserFilterPresenter(this);
    private static UserFilter userFilter = null;

    private static UserFilter getInstance(){
        if (userFilter == null){
            userFilter = new UserFilter();
        }
        return userFilter;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_filter);
        userFilter = this;
        initComponents();

    }

    private void initComponents() {
        User user = new User();
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        presenter.userFilter(user);
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }





    @Override
    public void successUserFilter(ArrayList<User> usersList) {
        LinearLayout usersColumn = findViewById(R.id.usersColumn);
        LinearLayout parentEl = null;

        //NULL POINTER NOT CHECK
        for (User user : usersList) {
            parentEl = usersColumn;
            Log.e("SuccesList", "ProductForEach" + user.toString());
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
            textView.setText(user.getIdUser() + " " + user.getUsername() + "\n" + "Nº DE VENTAS DEL USUARIO: " + user.getVenta());
            linearLayout.addView(textView);
            Log.e("listaPRODUCCTOS","LSIADO: " + user.getIdUser() + user.getUsername() + "\n" + user.getVenta());
            parentEl.addView(linearLayout);
        }
    }

    @Override
    public void failureUserFilter(String err) {

    }
}