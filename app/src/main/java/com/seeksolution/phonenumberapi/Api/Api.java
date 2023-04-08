package com.seeksolution.phonenumberapi.Api;

import com.seeksolution.phonenumberapi.Model.ContactModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("contact.php")
    Call<ContactModel> getUSer(
           @Field("number") String number
    );

}
