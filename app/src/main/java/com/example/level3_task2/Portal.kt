package com.example.level3_task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Portal (
    var portalName: String,
    var portalUrl: String
) : Parcelable