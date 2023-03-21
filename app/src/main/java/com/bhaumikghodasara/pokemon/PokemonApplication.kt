package com.bhaumikghodasara.pokemon

import android.app.Application
import android.graphics.drawable.PictureDrawable
import com.bhaumikghodasara.pokemon.util.glide.GlideApp
import com.bhaumikghodasara.pokemon.util.glide.SvgSoftwareLayerSetter
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PokemonApplication: Application(){
    private lateinit var requestBuilder: RequestBuilder<PictureDrawable>

    fun getGlideRequestBuilder(): RequestBuilder<PictureDrawable>{
        return if(this::requestBuilder.isInitialized){
            requestBuilder
        }else{
            requestBuilder = GlideApp.with(this)
                .`as`(PictureDrawable::class.java)
                .transition(withCrossFade())
                .listener(SvgSoftwareLayerSetter())
            requestBuilder
        }
    }
}