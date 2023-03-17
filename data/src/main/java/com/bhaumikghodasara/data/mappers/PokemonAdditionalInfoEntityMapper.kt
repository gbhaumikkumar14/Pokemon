package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.PokemonAdditionalInfo
import com.bhaumikghodasara.domain.entities.PokemonAdditionalInfoData

class PokemonAdditionalInfoEntityMapper: Mapper<PokemonAdditionalInfo, PokemonAdditionalInfoData> {
    override fun mapToDomainLayer(input: PokemonAdditionalInfo): PokemonAdditionalInfoData {
        val eggs = input.eggGroups.map { eggGroups -> eggGroups.name }.toList()

        return PokemonAdditionalInfoData(
            eggGroups = eggs,
            flavorTextEntries = input.flavorTextEntries.map { flavorTextEntries -> flavorTextEntries.flavorText }
                .toMutableList()[0].toString(),
            genderRate = input.genderRate,
            id = input.id,
            name = input.name,
            evolutionUrl = input.evolutionChain?.url,
        )
    }
}