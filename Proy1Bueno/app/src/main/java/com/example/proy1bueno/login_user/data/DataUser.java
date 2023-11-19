package com.example.proy1bueno.login_user.data;

import com.example.proy1bueno.beans.User;

import java.util.ArrayList;

public class DataUser {

    private String message;
    private ArrayList<User> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }

}
