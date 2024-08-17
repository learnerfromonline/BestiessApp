package com.example.besties.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.besties.R

data class People(
    @StringRes val name: Int,
    @StringRes val desc:Int,
    @DrawableRes val imageResourceId:Int,
    @StringRes val info:Int
)
val peoples= listOf(
    People(R.string.ram,R.string.ram_desc,R.drawable.ram,R.string.ram_info),
    People(R.string.pavan,R.string.pavan_desc,R.drawable.pavansai,R.string.pavan_info),
    People(R.string.sanjay ,R.string.sanjay_desc,R.drawable.sanjay,R.string.sanjay_info),
    People(R.string.koushik,R.string.koushik_desc,R.drawable.koushik,R.string.koushik_info),
    People(R.string.prasanth,R.string.prasanth_desc,R.drawable.prasanth,R.string.prasanth_info),
    People(R.string.hemanth,R.string.hemanth_desc,R.drawable.hemanth,R.string.hemanth_info)

)
