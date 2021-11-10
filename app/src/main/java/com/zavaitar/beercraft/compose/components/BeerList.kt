package com.zavaitar.beercraft.compose.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zavaitar.beercraft.compose.values.AppTheme
import com.zavaitar.beercraft.compose.values.smallPadding
import com.zavaitar.beercraft.data.Beer

@Composable
fun BeerList(list: List<Beer>) {
    AppTheme {
        Scaffold(
            topBar = { AppBar("Beers") }
        ) {
            LoadList(list) {
                // on click of item
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoadList(list: List<Beer>, onViewClick: (item: Beer) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(smallPadding)
    ) {
        items(list) { beer ->
            BeerListItem(beer.imageUrl, beer.name, beer.tagline) {
                onViewClick(beer)
            }
        }
    }
}

@Preview
@Composable
fun BeerListPreview() {
    BeerList(listOf())
}
