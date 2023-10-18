package com.example.loginandroid_29_09_2023.interfaces;

public interface CallBack<E> {
    void onResponse(Call<E> call, Response<E> response);
    void onFailure(Call<E>, Throwable t);

}
