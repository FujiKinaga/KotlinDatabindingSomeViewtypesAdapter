package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data.FeedData
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.databinding.MainFragmentBinding

/**
 * A placeholder fragment containing a simple view.
 */
class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataList: ObservableArrayList<FeedData> = ObservableArrayList()
        dataList.add(FeedData(FeedCellType.FEED))
        dataList.add(FeedData(FeedCellType.SPECIAL_FEED))
        dataList.add(FeedData(FeedCellType.LIMITED_FEED))
        dataList.add(FeedData(FeedCellType.CUSTOM_FEED))
        dataList.add(FeedData(FeedCellType.HEADER_AD))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD))
        dataList.add(FeedData(FeedCellType.OFFICIAL_AD))
        dataList.add(FeedData(FeedCellType.FEED))
        dataList.add(FeedData(FeedCellType.SPECIAL_FEED))
        dataList.add(FeedData(FeedCellType.LIMITED_FEED))
        dataList.add(FeedData(FeedCellType.CUSTOM_FEED))
        dataList.add(FeedData(FeedCellType.HEADER_AD))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD))
        dataList.add(FeedData(FeedCellType.OFFICIAL_AD))
        dataList.add(FeedData(FeedCellType.FEED))
        dataList.add(FeedData(FeedCellType.SPECIAL_FEED))
        dataList.add(FeedData(FeedCellType.LIMITED_FEED))
        dataList.add(FeedData(FeedCellType.CUSTOM_FEED))
        dataList.add(FeedData(FeedCellType.HEADER_AD))
        dataList.add(FeedData(FeedCellType.IN_FEED_AD))
        dataList.add(FeedData(FeedCellType.OFFICIAL_AD))

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FeedAdapter(dataList)
        }
    }
}
