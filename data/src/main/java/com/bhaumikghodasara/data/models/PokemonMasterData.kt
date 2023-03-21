package com.bhaumikghodasara.data.models

import com.bhaumikghodasara.domain.entities.PokemonAdditionalInfoData
import com.bhaumikghodasara.domain.entities.PokemonDetailData
import com.bhaumikghodasara.domain.entities.StrengthWeaknessData

data class PokemonMasterData(
    var pokemonDetailData: PokemonDetailData? = PokemonDetailData(),
    var pokemonAdditionalInfoData: PokemonAdditionalInfoData = PokemonAdditionalInfoData(),
    var strengthWeaknessData: StrengthWeaknessData? = StrengthWeaknessData(),
)