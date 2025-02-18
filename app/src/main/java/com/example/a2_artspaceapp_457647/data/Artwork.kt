package com.example.a2_artspaceapp_457647.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a2_artspaceapp_457647.R

data class Artwork(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    val title: String,
    val artist: String,
    val year: Int
)

val artworks= listOf(
    Artwork(1,R.drawable.gogh042,"Cypresses","Vincent van Gogh",1889),
    Artwork(2,R.drawable.munch004,"The Scream","Edvard Munch",1893),
    Artwork(3,R.drawable.fragonard002,"The Swing","Jean-Honore Fragonard",1767)
)