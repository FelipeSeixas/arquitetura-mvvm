package br.com.pokedex_egsys.di

import br.com.pokedex_egsys.PokemonRepository
import br.com.pokedex_egsys.data.remote.ServicePokeAPI
import br.com.pokedex_egsys.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule{
    fun providePokemonRepository(
//        api: PokeAPI
    api: ServicePokeAPI
    ) = PokemonRepository(api)

//    Conexão e conversão do consumo do serviço online e instâcia do retrofit
//    Implementação da interface que contém o endpoint da api pokedex
//    fun providePokeApi(): PokeAPI {
    fun providePokeApi(): ServicePokeAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())

//            EndPoint online do pokedex:
            .baseUrl(BASE_URL)
            .build()
            .create(ServicePokeAPI::class.java)
    }
}

