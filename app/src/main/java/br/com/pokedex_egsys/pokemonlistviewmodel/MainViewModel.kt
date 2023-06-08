package br.com.pokedex_egsys.pokemonlistviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pokedex_egsys.PokemonRepository
import br.com.pokedex_egsys.data.remote.responses.Pokemon
import br.com.pokedex_egsys.util.Constants.PAGE_SIZE
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val repository: PokemonRepository): ViewModel() {

    private var curPage = 0

    // Propriedades observáveis para os dados que serão exibidos na View
    private val pokemonList = MutableLiveData<List<Pokemon>>()
    private val selectedPokemon = MutableLiveData<Pokemon>()

    init {
        // Carregue a lista de Pokémons ao iniciar a ViewModel
        loadPokemonList()
    }

    // Método para carregar a lista de Pokémons
    private fun loadPokemonList() {

        viewModelScope.launch {
            val pokemons = repository.getPokemonList(PAGE_SIZE, curPage * PAGE_SIZE)
//            pokemonList.value = pokemons
        }
    }

    // Nome ou tipo
    fun searchPokemon(query: String) {
        // Implemente aqui a lógica para buscar Pokémons por nome ou tipo
    }

    fun getRandomPokemon() {

    }

    fun selectPokemon(pokemon: Pokemon) {
        selectedPokemon.value = pokemon
    }
}