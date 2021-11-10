package com.zavaitar.beercraft.presentation.adapter

import com.zavaitar.beercraft.data.Beer

interface ItemSelectedListener {
    fun onItemSelected(beer: Beer)
}