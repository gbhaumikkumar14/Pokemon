package com.bhaumikghodasara.pokemon.viewmodels

import androidx.lifecycle.ViewModel
import com.bhaumikghodasara.domain.usecases.PokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(pokemonUseCases: PokemonUseCases): ViewModel() {
}