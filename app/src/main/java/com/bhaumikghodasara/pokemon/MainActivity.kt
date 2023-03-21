package com.bhaumikghodasara.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhaumikghodasara.pokemon.databinding.ActivityMainBinding
import com.bhaumikghodasara.pokemon.fragments.PokemonHomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        // Replace activity container with pokemon home fragment
        supportFragmentManager.beginTransaction().apply {
            add(_binding.mainActivityContainer.id, PokemonHomeFragment())
        }.commit()
    }
}