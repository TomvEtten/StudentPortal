package hva.nl.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    var title: String,
    var uri: String
) : Parcelable