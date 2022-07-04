package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.taboola.hp4udemoapplication.databinding.FragmentArticleScreenBinding
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

private const val TBL_CLICKED_ITEM_URL = "tblClickedItemUrl"

class ArticleScreenFragment : Fragment() {

    private var tblClickedItemUrl: String? = ""
    private var screenToolbarTitle = "Article Screen"

    private lateinit var binding: FragmentArticleScreenBinding
    private val model: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tblClickedItemUrl = it.getString(TBL_CLICKED_ITEM_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding =  FragmentArticleScreenBinding.inflate(layoutInflater, container, false)
        binding.articleUrl.setText(tblClickedItemUrl)
        model.setToolbarTitle(requireActivity(),screenToolbarTitle)
        binding.loremIpsumHuge.movementMethod = ScrollingMovementMethod()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(tblClickedItemUrl: String) =
            ArticleScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(TBL_CLICKED_ITEM_URL, tblClickedItemUrl)
                }
            }
    }
}