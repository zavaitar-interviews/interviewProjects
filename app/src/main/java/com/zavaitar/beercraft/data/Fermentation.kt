package com.zavaitar.beercraft.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fermentation(
    @SerializedName("temp")
    val temp: Temp
): Parcelable