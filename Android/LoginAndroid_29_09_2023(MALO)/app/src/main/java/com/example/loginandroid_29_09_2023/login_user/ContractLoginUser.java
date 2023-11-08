package com.example.loginandroid_29_09_2023.login_user;

import com.example.loginandroid_29_09_2023.beans.User;

public interface ContractLoginUser {
    public interface View {
        public void succesLogin(User user);//viene del back
        void failureLogin(String err);//viene del back
        //void failureLogin(MyException ex);

    }

    public interface Presenter {
        //void login(String email, String pass);
        void login(User user); //IDA HACIA EL BACK!!
        //void login(ViewUser viewUser);

    }

    public interface Model {
        interface OnLoginUserListener {
            void onFinished(User user);//VUELTAA!!!
            void onFailure(String err);//VUELTAA!!!
        }

        void loginAPI(User user,
                      OnLoginUserListener onLoginUserListener);
    }
}
