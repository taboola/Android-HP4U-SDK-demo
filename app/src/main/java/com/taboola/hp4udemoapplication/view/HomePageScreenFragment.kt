package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.taboola.android.Taboola
import com.taboola.android.homepage.TBLHomePage
import com.taboola.android.homepage.TBLHomePageSettings
import com.taboola.android.listeners.TBLHomePageListener
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.HomePageItemClickListener
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.adapters.articles.HomePageAdapter
import com.taboola.hp4udemoapplication.databinding.FragmentHomePageScreenBinding
import com.taboola.hp4udemoapplication.repository.MockDataGenerator
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class HomePageScreenFragment : Fragment() {

    private val TAG = HomePageScreenFragment::class.java.simpleName

    private var homePage: TBLHomePage? = null
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
        val tblHomePageSettings: TBLHomePageSettings?  =
            TBLHomePageSettings.TBLHomePageSettingsBuilder(
                HP4UDemoConstants.HOME_PAGE_SOURCE_TYPE,
                HP4UDemoConstants.HOME_PAGE_PAGE_URL,
                HP4UDemoConstants.SECTION_1_NAME,
                HP4UDemoConstants.SECTION_2_NAME,
                HP4UDemoConstants.SECTION_3_NAME).build()
        homePage = Taboola.getHomePage(
            tblHomePageSettings,
            object : TBLHomePageListener() {
                override fun onHomePageItemClick(
                    sectionName: String?,
                    itemId: String?,
                    clickUrl: String?,
                    isOrganic: Boolean,
                    customData: String?
                ): Boolean {
                    model.switchFragment(
                        requireActivity(),
                        ArticleScreenFragment.newInstance(clickUrl)
                    )
                    return false
                }
            }
        )

        homePage?.fetchContent()
        homePage?.attach(binding.homepageRecyclerview)
        val homePageAdapter =
            HomePageAdapter(homePage, object : HomePageItemClickListener {
                override fun onClick(url: String) {
                    Log.d(TAG, "Article item clicked $url");
                    model.switchFragment(requireActivity(), ArticleScreenFragment.newInstance(url))
                }
            })
        binding.homepageRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = homePageAdapter
        }
        homePageAdapter.setData(MockDataGenerator.getGeneratedData())
    }

    override fun onResume() {
        super.onResume()
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        model.apply {
            setToolbarTitle(requireActivity(), HP4UDemoConstants.NEWS_SCREEN_TOOLBAR_TITLE)
            setToolbarTitleTextAppearance(toolbar, R.style.NoticeTextAppearance)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        homePage = null
    }
}