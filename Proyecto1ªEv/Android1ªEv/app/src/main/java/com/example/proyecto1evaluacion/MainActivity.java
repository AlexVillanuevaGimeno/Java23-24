package com.example.proyecto1evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Reemplaza "tu_layout" con el nombre de tu layout XML

        MaterialButton btnIndex = findViewById(R.id.btnIndex);
        btnIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará al hacer clic en el botón
                abrirLoginActivity();
            }
        });
    }

    private void abrirLoginActivity() {
        Intent intent = new Intent(this, Login.class); // Reemplaza "LoginActivity" con el nombre de tu clase de actividad de login
        startActivity(intent);
    }
}