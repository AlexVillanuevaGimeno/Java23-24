package com.example.proy1bueno.login_user.presenter;

import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.login_user.ContractLoginUser;
import com.example.proy1bueno.login_user.model.LoginUserModel;

public class LoginUserPresenter implements ContractLoginUser.Presenter, ContractLoginUser.Model.OnLoginUserListener {
    private ContractLoginUser.View view;
    private ContractLoginUser.Model model;

    public LoginUserPresenter(ContractLoginUser.View view){
        this.view = view;
        model = new LoginUserModel(this);
    }
    @Override
    public void login(User user) {model.loginAPI(user, this);}


    @Override
    public void onFinished(User user) {
        view.successLogin(user);
    }

    @Override
    public void onFailure(String err) {

    }

}
