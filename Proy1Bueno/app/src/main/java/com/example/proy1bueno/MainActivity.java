package com.example.proy1bueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proy1bueno.loginUser.view.LoginUser;
import com.example.proy1bueno.userFilter.view.UserFilter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIndex = findViewById(R.id.btnIndex);
        Button btnUserSells = findViewById(R.id.btnUserSells);
        btnIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará al hacer clic    en el botón
                abrirLoginActivity();
            }
        });

        btnUserSells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirUsuarioVentas();
            }
        });
    }




    private void abrirLoginActivity() {
        Intent intent = new Intent(this, LoginUser.class);
        startActivity(intent);
    }

    private void abrirUsuarioVentas(){
        Intent intent = new Intent(this, UserFilter.class);
        startActivity(intent);
    }
}