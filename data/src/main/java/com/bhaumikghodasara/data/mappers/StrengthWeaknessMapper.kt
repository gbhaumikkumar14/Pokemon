package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.StrengthWeaknessAPIResponse
import com.bhaumikghodasara.domain.entities.*
import javax.inject.Inject

class StrengthWeaknessMapper @Inject constructor()
    : Mapper<StrengthWeaknessAPIResponse, StrengthWeaknessData> {
    override fun mapToDomainLayer(input: StrengthWeaknessAPIResponse): StrengthWeaknessData {
        return StrengthWeaknessData(
            damageRelations = input.damageRelations?.doubleDamageFrom?.map { doubleDamageFrom -> doubleDamageFrom.name }?.toList()
                ?.let {
                    DamageRelations(
                        doubleDamageFrom = it
                    )
                },
            generation = Generation(name = input.generation?.name, url = input.generation?.url),
            id = input.id,
            name = input.name,
            names = input.names.map { names -> Names(name = names.name) }.toList(),
            pokemon = input.pokemon.map { pokemon -> Pokemon(name = pokemon.name, url = pokemon.url) }.toList()
        )
    }
}