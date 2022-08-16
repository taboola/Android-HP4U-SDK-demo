package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.databinding.FragmentArticleScreenBinding
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class ArticleScreenFragment : Fragment() {

    private var tblClickedItemUrl: String? = ""

    private lateinit var binding: FragmentArticleScreenBinding
    private val model: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tblClickedItemUrl = it.getString(HP4UDemoConstants.TBL_CLICKED_ITEM_URL_PREFIX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding =  FragmentArticleScreenBinding.inflate(layoutInflater, container, false)
        binding.articleUrl.text = tblClickedItemUrl
        model.setToolbarTitle(requireActivity(), HP4UDemoConstants.ARTICLE_SCREEN_TOOLBAR_TITLE)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(tblClickedItemUrl: String?) =
            ArticleScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(HP4UDemoConstants.TBL_CLICKED_ITEM_URL_PREFIX, tblClickedItemUrl)
                }
            }
    }
}