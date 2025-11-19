package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.taboola.android.Taboola
import com.taboola.android.homepage.TBLFetchContentCallback
import com.taboola.android.homepage.TBLHomePage
import com.taboola.android.homepage.TBLHomePageDataSource
import com.taboola.android.homepage.TBLHomePageSettings
import com.taboola.android.listeners.TBLHomePageListener
import com.taboola.android.tblnative.TBLRecommendationHomePageDataApiItem
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.HP4UDemoConstants.HOME_PAGE_PAGE_URL
import com.taboola.hp4udemoapplication.HP4UDemoConstants.SECTION_1_NAME
import com.taboola.hp4udemoapplication.HP4UDemoConstants.SECTION_2_NAME
import com.taboola.hp4udemoapplication.HP4UDemoConstants.SECTION_3_NAME
import com.taboola.hp4udemoapplication.HomePageItemClickListener
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.adapters.articles.HomePageAdapter
import com.taboola.hp4udemoapplication.databinding.FragmentHomePageScreenBinding
import com.taboola.hp4udemoapplication.model.Article
import com.taboola.hp4udemoapplication.model.BaseItem
import com.taboola.hp4udemoapplication.model.Header
import com.taboola.hp4udemoapplication.repository.MockDataGenerator
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class HomePageDataApiScreenFragment : Fragment() {

    private val TAG = HomePageDataApiScreenFragment::class.java.simpleName
    private lateinit var homePage: TBLHomePage
    private lateinit var binding: FragmentHomePageScreenBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var homePageAdapter: HomePageAdapter

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
        createHomePage()
        setUpRecyclerViewAdapter()
    }

    private fun createHomePage() {
        viewModel.setPublisherDataList(MockDataGenerator.getGeneratedData())

        val tblHomePageSettings: TBLHomePageSettings =
            TBLHomePageSettings.TBLHomePageSettingsBuilder(
                HOME_PAGE_PAGE_URL,
                SECTION_1_NAME, SECTION_2_NAME, SECTION_3_NAME
            ).build() ?: return

        homePage = Taboola.getHomePage(
            tblHomePageSettings,
            object : TBLHomePageListener() {
                override fun onHomePageStatusChanged(active: Boolean) {
                    super.onHomePageStatusChanged(active)

                    if (active) {
                        homePage.fetchContent(object : TBLFetchContentCallback {
                            override fun onComplete(
                                isHomePageEnabled: Boolean,
                                homePageDataSource: TBLHomePageDataSource
                            ) {
                                if (isHomePageEnabled) swapItems(homePageDataSource.items)
                            }

                            override fun onFailure(error: String) {}
                        })
                    } else {
                        Toast.makeText(requireContext(), "HomePage is not active.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onHomePageItemClick(
                    sectionName: String?,
                    itemId: String?,
                    clickUrl: String?,
                    isOrganic: Boolean,
                    customData: String?
                ): Boolean {
                    viewModel.switchFragment(
                        requireActivity(),
                        ArticleScreenFragment.newInstance(clickUrl)
                    )
                    return false
                }
            }
        )
    }

    private fun setUpRecyclerViewAdapter() {
        homePageAdapter =
            HomePageAdapter(null, true, object : HomePageItemClickListener {
                override fun onClick(url: String) {
                    Log.d(TAG, "Article item clicked $url");
                    viewModel.switchFragment(
                        requireActivity(),
                        ArticleScreenFragment.newInstance(url)
                    )
                }
            })

        binding.homepageRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = homePageAdapter
        }
        homePageAdapter.setData(viewModel.getPublisherDataList() as ArrayList<BaseItem>)
        homePage.attach(binding.homepageRecyclerview)
    }

    /**
     * Processes a list of home page items, identifying specific sections and potentially
     * swapping out a Publisher's item with a recommendation item.
     * This function mutates the main data list held by the ViewModel.
     */
    private fun swapItems(recommendationItems: HashMap<String, MutableList<TBLRecommendationHomePageDataApiItem>>) {
        var sectionStartPositionIndex = 0

        // Get the current list of items from the ViewModel and make it mutable for potential swapping.
        val listWithSwappedItems = viewModel.getPublisherDataList().toMutableList()
        var sectionName = ""

        // Iterate through every item in the list by its index (position).
        for (position in listWithSwappedItems.indices) {
            val currentItem = listWithSwappedItems[position]

            // Determine the current section context based on the item type.
            when (currentItem) {
                is Article -> sectionName = currentItem.sectionName
                is Header -> sectionStartPositionIndex = position + 1
            }

            // Check if a swap is needed at this specific position within the current section.
            if (homePage.shouldSwapItemInSectionDataApi(sectionName, position, sectionStartPositionIndex)) {
                // Calculate the item's position relative to the start of its section.
                // Example: If section starts at index 5 and current position is 7, relativePosition is 2.
                val relativePosition = position - sectionStartPositionIndex

                // Fetch the corresponding recommendation item from the pre-fetched map.
                val recommendation =
                    getTBLRecommendationHomePageDataApiItem(sectionName, recommendationItems, relativePosition)

                // If a valid recommendation item exists for this specific relative position, perform the swap and report the successful swap.
                if (recommendation != null) {
                    val swappedItem = createSwappedItem(sectionName, recommendation)
                    listWithSwappedItems[position] = swappedItem
                    homePage.reportSwapDataApi(sectionName, position, true)
                }
            }
        }

        viewModel.setPublisherDataList(listWithSwappedItems)
        requireActivity().runOnUiThread {
            homePageAdapter.setData(listWithSwappedItems as ArrayList)
        }
    }

    /**
     * Retrieves a specific recommendation item from a list associated with a section name,
     * based on its relative position (swapIndexInSection).
     */
    private fun getTBLRecommendationHomePageDataApiItem(
        sectionName: String,
        recommendationMap: HashMap<String, MutableList<TBLRecommendationHomePageDataApiItem>>,
        relativePosition: Int
    ): TBLRecommendationHomePageDataApiItem? {
        // Retrieve the list of recommendations associated with the provided sectionName
        val recommendationListForUnit = recommendationMap.get(sectionName)
        // Check if the list was not found or is empty. If so, there's no item to return.
        if (recommendationListForUnit == null || recommendationListForUnit.isEmpty()) return null

        // Iterate through all items in the section's list to find the one
        // whose 'swapIndexInSection' matches the requested relativePosition.
        for (item in recommendationListForUnit) {
            // Check if the item's index matches the requested position.
            if (relativePosition == item.swapIndexInSection) return item // Found the specific item at the requested relative position.
        }

        // If the loop completes without finding a match (i.e., no item in the list has
        // a 'swapIndexInSection' equal to relativePosition), return null.
        return null
    }

    private fun createSwappedItem(
        sectionName: String, recommendationItem: TBLRecommendationHomePageDataApiItem
    ): Article {
        return Article(
            recommendationItem.title,
            recommendationItem.description,
            0,
            recommendationItem.imageUrl,
            "",
            sectionName,
            true
        )
    }

    override fun onResume() {
        super.onResume()
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        viewModel.apply {
            setToolbarTitle(requireActivity(), HP4UDemoConstants.NEWS_SCREEN_TOOLBAR_TITLE)
            setToolbarTitleTextAppearance(toolbar, R.style.NoticeTextAppearance)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        homePage.clear()
    }
}