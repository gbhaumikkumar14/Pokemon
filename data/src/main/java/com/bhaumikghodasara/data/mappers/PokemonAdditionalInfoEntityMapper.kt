package com.bhaumikghodasara.data.mappers

import android.util.Log
import com.bhaumikghodasara.data.models.PokemonAdditionalInfo
import com.bhaumikghodasara.domain.entities.PokemonAdditionalInfoData
import javax.inject.Inject

class PokemonAdditionalInfoEntityMapper @Inject constructor()
    : Mapper<PokemonAdditionalInfo, PokemonAdditionalInfoData> {
    override fun mapToDomainLayer(input: PokemonAdditionalInfo): PokemonAdditionalInfoData {
        val eggs = input.eggGroups.map { eggGroups -> eggGroups.name }.toList()
        // Flavor text entries contains other languages also and also contains special chars
        val enStringList = input.flavorTextEntries
            .filter { entry -> entry.language?.name.equals("en") }
            .map { entry ->
                entry.flavorText?.let {
                    it.replace("\n", " ")
                        .replace("\u000c"," ")
                }
            }
            .distinct()
        val finalString = enStringList.toMutableList().toString()
            .replace(",","")
            .replace("[","")
            .replace("]","")
        return PokemonAdditionalInfoData(
            eggGroups = eggs,
            flavorTextEntries = finalString,
            genderRate = input.genderRate,
            id = input.id,
            name = input.name,
            evolutionUrl = input.evolutionChain?.url,
        )
    }
}