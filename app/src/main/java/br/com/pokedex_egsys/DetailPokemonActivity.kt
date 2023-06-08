package br.com.pokedex_egsys

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import br.com.pokedex_egsys.pokemondetailviewmodel.PokemonDetailViewModel
import br.com.pokedex_egsys.ui.components.DetailsOfPokemon

class DetailPokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)

        setContent {
            DetailsOfPokemon(
                "nameDefault",
                PokemonDetailViewModel
        }

    }
}