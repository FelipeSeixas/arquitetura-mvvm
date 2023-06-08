package br.com.pokedex_egsys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import br.com.pokedex_egsys.ui.components.PokemonListMainScreen

class MainPokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apresentacao)

        setContent {
            PokemonListMainScreen()
        }
    }
}