package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.adapters.articles.HomePageAdapter
import com.taboola.hp4udemoapplication.databinding.FragmentHomePageScreenBinding
import com.taboola.hp4udemoapplication.mock.DataGenerator
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class HomePageScreenFragment : Fragment() {
    private lateinit var binding: FragmentHomePageScreenBinding
    private val model: SharedViewModel by activityViewModels()

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
        val homePageAdapter =
            HomePageAdapter(model.getHomePage(), object : HomePageAdapter.OnItemClickListener {
                override fun onClick(url: String) {
                    Log.d("HomePageScreenFragment", "Article item clicked $url");
                    //TODO use this line to open article screen
                    // model.switchFragment(requireActivity(), )
                }
            })
        binding.homepageRecyclerview.adapter = homePageAdapter
        homePageAdapter.setData(DataGenerator.getGeneratedData())
    }

    override fun onResume() {
        super.onResume()
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        model.setToolbarTitle(requireActivity(), "News")
        model.setToolbarTitleTextAppearance(toolbar, R.style.NoticeTextAppearance)
        model.itemClicked().observe(this, Observer {
            //TODO use this line to open article screen
            // model.switchFragment(requireActivity(), )
        })
    }
}