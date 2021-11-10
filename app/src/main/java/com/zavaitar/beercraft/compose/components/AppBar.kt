package com.zavaitar.beercraft.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zavaitar.beercraft.compose.values.appBarStyle

@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    title,
                    style = appBarStyle
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview
@Composable
fun AppBarPreview() {
    AppBar(title = "Beer List")
}