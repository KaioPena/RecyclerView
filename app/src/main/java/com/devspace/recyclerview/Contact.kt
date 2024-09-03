package com.devspace.recyclerview

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes

    //Dataclass que precisa ser criado para o RecyclerView
data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val icon: Int
)


