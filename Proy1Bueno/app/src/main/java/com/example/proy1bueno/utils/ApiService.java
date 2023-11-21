package com.example.proy1bueno.utils;

import com.example.proy1bueno.listProductsUser.data.DataProduct;
import com.example.proy1bueno.login_user.data.DataUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @GET("MyServlet")
    Call<DataUser> getDataLoginUser(@Query("ACTION") String action, @Query("username") String username, @Query("password") String password);

    @GET("MyServlet")
      Call<DataProduct> getDataProductList(@Query("ACTION") String action);

    @GET("MyServlet")
    Call<DataProduct> getDataProductList(@Query("ACTION") String action, @Query("idUser")int idUser);

//    @GET("MyServlet")
//    Call<DataMovies> getDataMovies(@Query("ACTION") String action);

//    @GET("MyServlet")
//    Call<DataMovies> getDataMovies2(@Query("ACTION") String action);

        /*
        @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);

        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);*/

        /*
        @FormUrlEncoded
        @POST("/login")
        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
    */
}
