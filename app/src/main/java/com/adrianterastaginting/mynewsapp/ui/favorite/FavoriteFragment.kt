package com.adrianterastaginting.mynewsapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
//import com.adrianterastaginting.mynewsapp.databinding.FragmentDashboardBinding
import com.adrianterastaginting.mynewsapp.databinding.FragmentFavoriteBinding
import com.adrianterastaginting.mynewsapp.ui.home.NewsAdapter

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private lateinit var adapter: FavoritAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
        adapter = FavoritAdapter(this)
        binding.favoriteRecyclerView.adapter = adapter
        binding.favoriteRecyclerView.layoutManager = LinearLayoutManager(context)
*/



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}