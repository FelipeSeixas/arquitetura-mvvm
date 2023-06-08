package br.com.pokedex_egsys.data.remote.responses

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)