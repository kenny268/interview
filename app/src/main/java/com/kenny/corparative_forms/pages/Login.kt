package com.kenny.corparative_forms.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kenny.corparative_forms.controller.addUser
import com.kenny.corparative_forms.ui.theme.Corparative_formsTheme

@Composable
fun Login(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()

    ){
        Column (

            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val username = remember {
                mutableStateOf(TextFieldValue())
            }

            val password = remember {
                mutableStateOf(TextFieldValue())
            }
            val ctx = LocalContext.current

            val response = remember {
                mutableStateOf("")
            }

            val navController = rememberNavController()

            Text(
                text = "Login",
                style = TextStyle(fontSize =  40.sp, fontFamily = FontFamily.Cursive)
            )
            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Username")},
                value = username.value,
                onValueChange = {username.value= it}
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                label = { Text(text = "Password")},
                value = password.value,
                onValueChange = {password.value= it}
            )
            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
                Button(
                    onClick = {
                        // on below line we are calling make payment method to update data.
                        addUser(
                            ctx, username, password, response,
                        )
                        navController.navigate("welcome")
                    },

                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login")
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPrevieww() {
    Corparative_formsTheme {
        val navController = rememberNavController()
//        Login(navController)

    }

}