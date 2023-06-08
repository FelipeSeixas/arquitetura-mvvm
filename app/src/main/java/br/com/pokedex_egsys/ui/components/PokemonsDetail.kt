package br.com.pokedex_egsys.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.com.pokedex_egsys.pokemondetailviewmodel.PokemonDetailViewModel

@Composable
fun DetailsOfPokemon(
    namePoke: String = "",
    viewModel: PokemonDetailViewModel
){
//Imagem
    Image(imageVector = viewModel.getPokemonInfo(namePoke).data.image, contentDescription = "Detalhes dos pokemons" )

//Nome - Via função de scopo
    viewModel.getPokemonInfo(namePoke).data?.let { Text(text = it.name) }

//Peso
    Text(text = viewModel.getPokemonInfo(namePoke).data?.weight)

//Altura
    Text(text = viewModel.getPokemonInfo(namePoke).data?.height)

}