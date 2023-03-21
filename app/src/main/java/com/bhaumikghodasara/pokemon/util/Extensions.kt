package com.bhaumikghodasara.pokemon.util

import android.widget.ImageView
import com.bhaumikghodasara.pokemon.R
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    url: String = "",
    placeHolderDrawable: Int = R.mipmap.ic_launcher,
) {
    if (url.isNotEmpty())
        Glide.with(this.context)
            .asBitmap()
            .load(url)
            .into(this)
}

fun String.isLetters(): Boolean {
    return this.matches("^[a-zA-Z]*$".toRegex())
}
fun String.capitalizeFirstCharacter() : String {
    return this
        .substring(0, 1).uppercase() + this.substring(1)
}