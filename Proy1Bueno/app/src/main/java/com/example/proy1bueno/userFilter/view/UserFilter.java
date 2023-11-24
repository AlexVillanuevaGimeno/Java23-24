package com.example.proy1bueno.userFilter.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.proy1bueno.MainActivity;
import com.example.proy1bueno.R;
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
        LinearLayout parentEl = null;
    }

    @Override
    public void failureUserFilter(String err) {

    }
}