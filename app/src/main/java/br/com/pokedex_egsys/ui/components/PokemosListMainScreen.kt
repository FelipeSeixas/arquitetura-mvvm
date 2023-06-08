package br.com.pokedex_egsys.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import br.com.pokedex_egsys.DetailPokemonActivity
import br.com.pokedex_egsys.R
import br.com.pokedex_egsys.data.remote.responses.Pokemon
import br.com.pokedex_egsys.pokemonlistviewmodel.MainViewModel

//Tela principal do aplicativo. Nela irá filtrar e listar os Pokémons.
//■ Filtros mínimos: por nome e tipo de Pokémon
//■ Campos mínimos para a listagem: nome e imagem

//@Preview (showBackground = true)
@Composable
fun PokemonListMainScreen(
    viewModelMain: MainViewModel
) {

    Column {

        Image(
            painter = painterResource(id = R.drawable.pokedefault),

            contentDescription = "Pokemon - Geral - Tela inicial",
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)

//Clique habilitado na imagem
                .clickable {
                    viewModelMain.getRandomPokemon()
                    val context = LocalContext.current
                    val intent = Intent(context, DetailPokemonActivity::class.java)
                    context.startActivity(intent)
                }
        )

        Text(text = "Filtro (nome e tipo)")
        Text(viewModelMain.searchPokemon(""))

        SearchBar(
            hint = "Digite aqui o nome do pokemon",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            viewModelMain.searchPokemon(it)
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    var isHintDisplayed by remember {  mutableStateOf(hint != "")   }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused
                }
        )

        if (isHintDisplayed) {
            Text(text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }

}

//LazyColumn com a lista de Pokémons obtidos da API PokeAPI:
@Composable
fun PokemonList() {
    val pokemonList = remember { mutableStateListOf<Pokemon>() }

    LaunchedEffect(Unit) {
        val response = searchPokemon()
        pokemonList.addAll(response.results)
    }

    LazyColumn {
        items(pokemonList) { pokemon ->
            Text(pokemon.name)
        }
    }
}

//Filtro por tipo do pokemon
//@Preview
@Composable
fun DropdownDemo(
    viewModel_: Pokemon
) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf(viewModel_)
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column {
        Text(selectedOption)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = option,
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
        }
        Button(onClick = { expanded = !expanded }) {
            Text("Selecione uma opção")
        }
    }
}}

//@Preview
@Composable
fun RandomPokemon(
    viewModelMain: MainViewModel
){
    
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {

            viewModelMain.getRandomPokemon()
            val context = LocalContext.current
            val intent = Intent(context, DetailPokemonActivity::class.java)
            context.startActivity(intent)
        },
        contentPadding = PaddingValues(
            start = 8.dp,
            top = 4.dp,
            end = 8.dp,
            bottom = 4.dp
        )
    ) {
        Text("Poke aleatório")

        Image(
            painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
            contentDescription = "Pokemon - Geral - Tela inicial",
        )

        Text(
            modifier = Modifier
                .size(32.dp)
                .fillMaxWidth(1f),
            text = "Aleatório",
        )
    }
}