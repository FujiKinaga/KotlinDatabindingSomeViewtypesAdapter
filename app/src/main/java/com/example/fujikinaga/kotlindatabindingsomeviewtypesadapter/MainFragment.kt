package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad.AdView
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad.AdViewModel
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data.FeedData
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.databinding.MainFragmentBinding

/**
 * A placeholder fragment containing a simple view.
 */
class MainFragment : Fragment(), FeedAdapter.OnAdapterInteractionListener {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataList: ObservableArrayList<FeedData> = ObservableArrayList()
        dataList.add(FeedData(FeedCellType.FEED, 1, 10, null))
        dataList.add(FeedData(FeedCellType.SPECIAL_FEED, 2, 20, null))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD, null, null, null))
        dataList.add(FeedData(FeedCellType.LIMITED_FEED, 3, 30, null))
        dataList.add(FeedData(FeedCellType.CUSTOM_FEED, 4, 40, null))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD, null, null, null))
        dataList.add(FeedData(FeedCellType.OFFICIAL_AD, 5, null, "http://google.com"))
        dataList.add(FeedData(FeedCellType.FEED, 6, 60, null))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD, null, null, null))
        dataList.add(FeedData(FeedCellType.SPECIAL_FEED, 7, 70, null))
        dataList.add(FeedData(FeedCellType.OFFICIAL_AD, 8, null, "http://rakuten.com"))
        dataList.add(FeedData(FeedCellType.FEED, 9, 90, null))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD, null, null, null))

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FeedAdapter(this@MainFragment, dataList)
        }
    }

    override fun onUserIconClick(userId: Int) {
        Toast.makeText(context, "onUserIconClick: $userId", Toast.LENGTH_SHORT).show()
    }

    override fun onFeedClick(feedId: Int) {
        Toast.makeText(context, "onFeedClick: $feedId", Toast.LENGTH_SHORT).show()
    }

    override fun onOfficialAdClick(url: String) {
        Toast.makeText(context, "onOfficialAdClick: $url", Toast.LENGTH_SHORT).show()
    }

    override fun getAdView(): AdView? {
        val activity = activity ?: return null
        val viewModel = ViewModelProviders.of(activity).get(AdViewModel::class.java)
        return viewModel.adViewForBindToAdapter
    }
}
