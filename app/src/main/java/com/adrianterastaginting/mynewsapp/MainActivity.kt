package com.adrianterastaginting.mynewsapp

import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.mynewsapp.databinding.ActivityMainBinding
import com.adrianterastaginting.mynewsapp.ui.home.Article
import com.adrianterastaginting.mynewsapp.ui.home.NewsAdapter
import com.adrianterastaginting.mynewsapp.ui.home.NewsApiResponse
import okhttp3.Callback
import okhttp3.Response

class MainActivity : AppCompatActivity()/*, NewsAdapter.OnItemClickListener */{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

    }

}