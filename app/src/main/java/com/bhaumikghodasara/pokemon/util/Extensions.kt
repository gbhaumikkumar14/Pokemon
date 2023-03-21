package com.bhaumikghodasara.pokemon.util

import android.widget.ImageView
import com.bhaumikghodasara.pokemon.PokemonApplication
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(
    pokemonId: String = "",
) {
    if (pokemonId.isNotEmpty())
        (this.context.applicationContext as PokemonApplication).getGlideRequestBuilder()
            .load("${Constants.BASE_IMAGE_URL}$pokemonId${Constants.IMG_EXTENSION}")
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(this)
}

fun String.isLetters(): Boolean {
    return this.matches("^[a-zA-Z]*$".toRegex())
}
fun String.capitalizeFirstCharacter() : String {
    return this
        .substring(0, 1).uppercase() + this.substring(1)
}