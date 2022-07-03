package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.databinding.FragmentArticleScreenBinding
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel


class ArticleScreenFragment : Fragment() {

    private lateinit var binding: FragmentArticleScreenBinding
    private val model: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding =  FragmentArticleScreenBinding.inflate(layoutInflater, container, false)
        binding.articleUrl.setText(model.getTblItemUrl())
        binding.loremIpsumHuge.movementMethod = ScrollingMovementMethod()

        return binding.root
    }

}