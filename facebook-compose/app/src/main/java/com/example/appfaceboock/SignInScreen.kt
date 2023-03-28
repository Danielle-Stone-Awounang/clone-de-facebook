package com.example.appfaceboock

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen() {
    Box(
        Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()){

        Column (Modifier
            .fillMaxWidth()
            .padding(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(Icons.Rounded.Facebook, contentDescription = null ,
            modifier = Modifier.size(90.dp),
            tint = MaterialTheme.colors.primary
            )
            Spacer(Modifier.height(28.dp))
            Text("Sign in with facebook")
        }
    }
}