package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.EvolutionChainApiResponse
import com.bhaumikghodasara.data.models.EvolvesTo
import com.bhaumikghodasara.domain.entities.EvolutionChainData
import com.bhaumikghodasara.domain.entities.Species

class EvolutionChainEntityMapper
    : Mapper<EvolutionChainApiResponse, EvolutionChainData>
{
    override fun mapToDomainLayer(input: EvolutionChainApiResponse): EvolutionChainData {
        val resultSpecies: MutableList<Species> = mutableListOf()
        resultSpecies.add(Species(input.chain?.species?.name, input.chain?.species?.url))
        getSpecies(input.chain?.evolvesTo, resultSpecies)
        return EvolutionChainData(resultSpecies)
    }

    private fun getSpecies(evolvesTo: List<EvolvesTo>?, resultSpecies: MutableList<Species>) {
        if (evolvesTo != null) {
            for (evolveObj in evolvesTo) {
                resultSpecies.add(
                    Species(
                        name = evolveObj.species?.name,
                        url = evolveObj.species?.url
                    )
                )
                getSpecies(evolveObj.evolvesTo, resultSpecies)
            }
        }
    }
}