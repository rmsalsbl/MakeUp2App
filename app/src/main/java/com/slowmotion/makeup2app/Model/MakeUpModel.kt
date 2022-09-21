package com.slowmotion.makeup2app.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MakeUpModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("Name")
    val Name: String?,

    @SerializedName("Description")
    val Description: String?,

    @SerializedName("Picture")
    val Picture: String?,

    @SerializedName("Price")
    val Price: String?,


    ): Parcelable
