package br.com.pokedex_egsys

import javax.inject.Inject
import br.com.pokedex_egsys.data.remote.ServicePokeAPI
import br.com.pokedex_egsys.util.Resource
import br.com.pokedex_egsys.data.remote.responses.Pokemon
import br.com.pokedex_egsys.data.remote.responses.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception

//O Repository gerenciará as consultas e as atualizações de dados do webservice
//E será vinculado a partir das ViewsModels
@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: ServicePokeAPI
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred - GetPokemonList")
        }
            return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred - GetPokemonInfo ")
        }
            return Resource.Success(response)
    }
}
annotation class ActivityScoped