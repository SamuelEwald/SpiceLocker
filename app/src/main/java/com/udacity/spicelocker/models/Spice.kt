package com.udacity.spicelocker.models

import android.graphics.Bitmap
import android.media.Image
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Spice(var name: String,
                 var unit: String,
                 var volume: Double,
                 var used : Double,
                 var brand: String,
                 var description: String//,
                 //val image: Bitmap?
) : Parcelable