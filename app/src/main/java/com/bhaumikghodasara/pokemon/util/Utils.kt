package com.bhaumikghodasara.pokemon.util

import android.content.Context
import android.graphics.drawable.GradientDrawable
import com.bhaumikghodasara.pokemon.R
import kotlin.math.roundToInt

class Utils {
    companion object {
        fun getTypesColor(type: String, context: Context): Int{
            if(type.equals("firing", true)) {
                return context.resources.getColor(R.color.fighting, null)
            } else if(type.equals("normal", true)) {
                return context.resources.getColor(R.color.normal, null)
            }else if(type.equals("flying", true)) {
                return context.resources.getColor(R.color.flying, null)
            }else if(type.equals("poison", true)) {
                return context.resources.getColor(R.color.poison, null)
            }else if(type.equals("ground", true)) {
                return context.resources.getColor(R.color.ground, null)
            }else if(type.equals("rock", true)) {
                return context.resources.getColor(R.color.rock, null)
            }else if(type.equals("bug", true)) {
                return context.resources.getColor(R.color.bug, null)
            }else if(type.equals("ghost", true)) {
                return context.resources.getColor(R.color.ghost, null)
            }else if(type.equals("steel", true)) {
                return context.resources.getColor(R.color.steel, null)
            }else if(type.equals("fire", true)) {
                return context.resources.getColor(R.color.fire, null)
            }else if(type.equals("water", true)) {
                return context.resources.getColor(R.color.water, null)
            }else if(type.equals("grass", true)) {
                return context.resources.getColor(R.color.grass, null)
            }else if(type.equals("electric", true)) {
                return context.resources.getColor(R.color.electric, null)
            }else if(type.equals("psychic", true)) {
                return context.resources.getColor(R.color.psychic, null)
            }else if(type.equals("ice", true)) {
                return context.resources.getColor(R.color.ice, null)
            }else if(type.equals("dragon", true)) {
                return context.resources.getColor(R.color.dragon, null)
            }else if(type.equals("dark", true)) {
                return context.resources.getColor(R.color.dark, null)
            }else if(type.equals("fairy", true)) {
                return context.resources.getColor(R.color.fairy, null)
            }else if(type.equals("unknown", true)) {
                return context.resources.getColor(R.color.unknown, null)
            }else if(type.equals("shadow", true)) {
                return context.resources.getColor(R.color.shadow, null)
            } else {
                return context.resources.getColor(R.color.normal, null)
            }
        }

        private fun getGradient(colorsArray: MutableList<Int>): GradientDrawable {
            return GradientDrawable().apply {
                colors = colorsArray.toIntArray()
                orientation = GradientDrawable.Orientation.TOP_BOTTOM
                gradientType = GradientDrawable.LINEAR_GRADIENT
                shape = GradientDrawable.RECTANGLE
            }
        }

        fun getGradientColors(requireContext: Context, types: MutableList<String?>): GradientDrawable {
            val colorsList: MutableList<Int> = ArrayList()
            for (type in types) {
                type?.let { colorsList.add(getTypesColor(type, requireContext)) }
            }
            if(colorsList.size < 2) {
                colorsList.add(colorsList[0])
            }
            return getGradient(colorsList)
        }

        fun getHeightInFtInchFromDecimeter(heightInDecimeter: Int?): String{
            heightInDecimeter?.let {
                val inch = heightInDecimeter * 3.9370
                val ft = inch / 12
                val remainingInch = inch % 12
                return "${ft.toInt()}'${remainingInch.roundToInt()}\""
            }
            return "0'0\""
        }

        fun getWightFromHectoGrams(weight: Int?): String{
            weight?.let {
                val grams = weight * 100
                if(grams > 1000){
                    val kilos = grams/1000
                    val remainingGrams = grams % 1000
                    return "$kilos${
                        if(remainingGrams != 0) ".${remainingGrams.toString().substring(0,1)}" 
                        else ""} Kg"
                }else{
                    return "$grams g"
                }
            }
            return "0 Kg"
        }
    }
}