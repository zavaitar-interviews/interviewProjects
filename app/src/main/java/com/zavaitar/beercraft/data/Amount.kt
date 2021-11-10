package com.zavaitar.beercraft.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Amount(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Double
): Parcelable