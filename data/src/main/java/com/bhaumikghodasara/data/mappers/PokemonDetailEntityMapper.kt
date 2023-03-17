package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.PokemonDetailsApiResponse
import com.bhaumikghodasara.domain.entities.*

class PokemonDetailEntityMapper: Mapper<PokemonDetailsApiResponse, PokemonDetailData> {
    override fun mapToDomainLayer(input: PokemonDetailsApiResponse): PokemonDetailData {
        return PokemonDetailData(
            abilities = input.abilities.map { abilities ->
                Abilities(
                    ability = Ability(name = abilities.ability?.name, url = abilities.ability?.url),
                    isHidden = abilities.isHidden,
                    slot = abilities.slot
                )
            }.toMutableList(),
            height = input.height,
            id = input.id,
            isDefault = input.isDefault,
            name = input.name,
            sprites = Sprites(frontDefault = input.sprites?.frontDefault),
            stats = input.stats.map { stats ->
                Stats(
                    baseStat = stats.baseStat,
                    effort = stats.effort,
                    stat = Stat(name = stats.stat?.name, url = stats.stat?.url)
                )
            }.toMutableList(),
            types = input.types.map { types ->
                Types(
                    slot = types.slot,
                    type = Type(name = types.type?.name, url = types.type?.url)
                )
            }.toMutableList(),
            weight = input.weight
        )
    }
}