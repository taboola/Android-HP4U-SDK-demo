package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.taboola.hp4udemoapplication.adapters.articles.HomePageAdapter
import com.taboola.hp4udemoapplication.databinding.FragmentHomePageScreenBinding
import com.taboola.hp4udemoapplication.mock.DataGenerator

class HomePageScreenFragment : Fragment() {
    private lateinit var binding: FragmentHomePageScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentHomePageScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homepageRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val homePageAdapter = HomePageAdapter(object : HomePageAdapter.OnItemClickListener{
            override fun onClick(url: String) {
                Log.d("HomePageScreenFragment", "Article item clicked $url");
            }
        })
        binding.homepageRecyclerview.adapter = homePageAdapter
        homePageAdapter.setData(DataGenerator.getGeneratedData())
    }

}