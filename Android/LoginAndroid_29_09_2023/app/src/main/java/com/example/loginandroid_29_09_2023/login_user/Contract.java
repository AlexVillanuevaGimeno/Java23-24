package com.example.loginandroid_29_09_2023.login_user;

public interface Contract {
    public interface View{
        public void succesLogin(User user);
        void failureLogin(String err);
        //void failureLogin(MyException ex);

    }
    public interface Presenter{
        void login(String email, String pass);
        void login(User user);
        void login(ViewUser viewUser);

    }
    public interface Model{
        interface OnLoginUserL{
            void OnFinished();
            void onFailure(String err);
        }
        void loginAPI(User user, OnLoginUserL onLoginUserL);    }
}
