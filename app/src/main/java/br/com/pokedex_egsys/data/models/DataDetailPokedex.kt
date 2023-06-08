package br.com.pokedex_egsys.data.models

//Estrutura de dados mínima para receber as informações da API externa
data class DataDetailPokedex(
    val name: String?,
    val imageURL: String?,
    val weight: Float?,
    val type: String?,
    val typeSecondary: String?
)
