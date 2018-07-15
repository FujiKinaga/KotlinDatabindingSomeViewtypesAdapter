package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad.AdView
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data.FeedData

class FeedAdapter(private val listener: OnAdapterInteractionListener, private var dataList: ObservableArrayList<FeedData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var recyclerView: RecyclerView? = null

    interface OnAdapterInteractionListener {
        fun onUserIconClick(userId: Int)
        fun onFeedClick(feedId: Int)
        fun onOfficialAdClick(url: String)
        fun getAdView(): AdView?
    }

    init {
        dataList.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<FeedData>>() {
            override fun onChanged(takes: ObservableList<FeedData>) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(takes: ObservableList<FeedData>, i: Int, i1: Int) {
                notifyItemRangeChanged(i, i1)
            }

            override fun onItemRangeInserted(takes: ObservableList<FeedData>, i: Int, i1: Int) {
                notifyItemRangeInserted(i, i1)
            }

            override fun onItemRangeMoved(takes: ObservableList<FeedData>, i: Int, i1: Int, i2: Int) {
                notifyItemMoved(i, i1)
            }

            override fun onItemRangeRemoved(items: ObservableList<FeedData>, i: Int, i1: Int) {
                notifyItemRangeRemoved(i, i1)
            }
        })
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].feedCellType.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FeedCellType.forOrder(viewType).getViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feedData = dataList[position]
        feedData.feedCellType.initialize(holder, feedData, listener)
    }
}