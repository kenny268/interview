package com.kenny.corparative_forms.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import com.kenny.corparative_forms.R
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kenny.corparative_forms.components.CustomTopAppBar
import com.kenny.corparative_forms.ui.theme.Corparative_formsTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Welcome(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .paint(painter = painterResource(id = R.drawable.asset)),
        ){

        Scaffold(
            topBar = {
                CustomTopAppBar(
                    navController=navController,
                    showBackIcon = true
                )},
            content = {
                Column (
                    modifier = Modifier
                        .padding(40.dp, 100.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                    

                ){

                    var username:String?= null;



                    Text(
                        text = "Welcome ${username}",
                        style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    Spacer(modifier = Modifier.height(15.dp))

                }


            }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewnw() {
    Corparative_formsTheme {
        val navController = rememberNavController()
        Welcome(navController)

    }

}