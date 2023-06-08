package br.com.pokedex_egsys.data.remote

import br.com.pokedex_egsys.data.remote.responses.Pokemon
import br.com.pokedex_egsys.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Realiza as solicitações HTTP, via Retrofit2, para a API (endpoints) visando obter os dados dos Pokémons

interface ServicePokeAPI {

//    Este endpoint retorna as informações detalhadas sobre um Pokémon específico, incluindo seu tipo ou subtipo.
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

    //    Paginação da lista
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList
}