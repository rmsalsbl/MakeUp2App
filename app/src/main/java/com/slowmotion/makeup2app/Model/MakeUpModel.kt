package com.slowmotion.makeup2app.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MakeUpModel(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("Name")
    val Name: String? = null,

    @SerializedName("Description")
    val Description: String? = null,

    @SerializedName("Picture")
    val Picture: String? = null,

    @SerializedName("Price")
    val Price: String? = null,


    ): Parcelable
