package com.kenny.corparative_forms.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("users")
    fun
            postData(@Body userModel: UserModel?): Call<UserModel?>?
}