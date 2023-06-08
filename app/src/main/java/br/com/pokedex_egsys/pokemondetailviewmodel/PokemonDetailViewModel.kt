package br.com.pokedex_egsys.pokemondetailviewmodel

import androidx.lifecycle.ViewModel
import br.com.pokedex_egsys.PokemonRepository
import br.com.pokedex_egsys.data.remote.responses.Pokemon
import br.com.pokedex_egsys.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) :ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }

}