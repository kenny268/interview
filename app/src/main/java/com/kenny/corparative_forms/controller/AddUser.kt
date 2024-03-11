package com.kenny.corparative_forms.controller
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.kenny.corparative_forms.models.RetrofitAPI
import com.kenny.corparative_forms.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import android.widget.Toast
import androidx.navigation.compose.rememberNavController
import retrofit2.converter.gson.GsonConverterFactory


fun addUser(
    ctx: Context,
    userName: MutableState<TextFieldValue>,
    job: MutableState<TextFieldValue>,
    result: MutableState<String>
) {
    var url = "https://dummyjson.com/auth/login"
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    val userModel = UserModel(userName.value.text, job.value.text)
    val call: Call<UserModel?>? = retrofitAPI.postData(userModel)

    call!!.enqueue(object : Callback<UserModel?> {
        override fun onResponse(call: Call<UserModel?>?, response: Response<UserModel?>) {
            val model: UserModel? = response.body()
            val resp = "Response Code : " + response.code() + "\n" + "User Name : " + model!!.username + "\n" + "Job : "
            result.value = resp
//            navController.navigate('')


        }

        override fun onFailure(call: Call<UserModel?>?, t: Throwable) {
            result.value = "Error found is : " + t.message
        }
    })

}