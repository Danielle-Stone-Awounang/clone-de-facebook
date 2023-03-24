package com.example.facebook_clone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChatBubble
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.facebook_clone.ui.theme.ButtonGray
import com.example.facebook_clone.ui.theme.Shapes

@Composable
fun HomeScreen(){
    
    Box(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()){

        TopAppbar()
        TapBar()
    }

    
}

@Composable
fun TapBar() {
    var index by remember {
        mutableStateOf(0)
    }
    TabRow (selectedTabIndex = index,
    backgroundColor = Color.Transparent,
    contentColor = MaterialTheme.colors.onSurface){
        Tab(selected = index === 0, onClick = {index = 0}){
            Icon(Icons.Rounded.Home, contentDescription = stringResource(R.string.home))
        }
    }
}

@Composable
fun TopAppbar() {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            stringResource(R.string.app_name),
            style = MaterialTheme.typography.h6
        )

        Spacer(Modifier.weight(1f))

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonGray)
        ) {
            Icon(Icons.Rounded.Search, stringResource(R.string.search))
        }

        Spacer(Modifier.width(8.dp))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonGray)
        ) {
            Icon(Icons.Rounded.ChatBubble, stringResource(R.string.search))
        }

    }

}
