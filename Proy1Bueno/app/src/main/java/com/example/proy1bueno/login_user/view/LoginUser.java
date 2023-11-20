package com.example.proy1bueno.login_user.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proy1bueno.R;
import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.login_user.ContractLoginUser;
import com.example.proy1bueno.login_user.persenter.LoginUserPresenter;

public class LoginUser extends AppCompatActivity implements ContractLoginUser.View{
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginUserPresenter presenter =
            new LoginUserPresenter(this);

    /* PATRÃ“N SINGLETON*/
    private static LoginUser mainActivity = null;
    public static LoginUser getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÃ“N SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        mainActivity = this;
        initComponents();

    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            //change user to login
            @Override
            public void onClick(View v) {
                //Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
                //sPeliculas.getDatosPeliculas();
                User user = new User();
                user.setUsername(edtEmail.getText().toString());
                user.setPassword(edtPassword.getText().toString());
                Log.e("User To string","User: " + user);
                presenter.login(user);
            }
        });
    }


    @Override
    public void successLogin(User user) {
        Toast.makeText(mainActivity, user.getUsername(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {

    }

}