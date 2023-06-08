package br.com.pokedex_egsys.data.remote.responses

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
)