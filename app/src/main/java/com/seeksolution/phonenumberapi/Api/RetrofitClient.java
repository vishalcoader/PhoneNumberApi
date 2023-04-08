package com.seeksolution.phonenumberapi.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String Url = "https://cf87-2402-3a80-1f8a-6aa0-1c8e-7226-ed1a-c12a.in.ngrok.io/contactapi/";
    private static  RetrofitClient retrofitclient;
    private static Retrofit retrofit;

    public RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance()
    {
        if (retrofitclient==null){
            retrofitclient = new RetrofitClient();
        }
        return retrofitclient;

    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }
}
