package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.PokemonListApiResponse
import com.bhaumikghodasara.domain.entities.PokemonData
import com.bhaumikghodasara.domain.entities.Results

class PokemonListEntityMapper: Mapper<PokemonListApiResponse, PokemonData> {
    override fun mapToDomainLayer(input: PokemonListApiResponse): PokemonData {
        return PokemonData(count = input.count, next = input.next, previous = input.previous,
            results = input.results.map { results ->
                Results(
                    name = results.name,
                    url = results.url
                )
            }.toMutableList()
        )
    }
}