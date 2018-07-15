package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data.FeedData
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.databinding.ItemFeedViewBinding
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.databinding.ItemOfficialAdViewBinding

enum class FeedCellType {
    FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return FeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val feedViewHolder = holder as? FeedViewHolder
            val binding = feedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    SPECIAL_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return SpecialFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val specialFeedViewHolder = holder as? SpecialFeedViewHolder
            val binding = specialFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    LIMITED_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return LimitedFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val limitedFeedViewHolder = holder as? LimitedFeedViewHolder
            val binding = limitedFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    CUSTOM_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return CustomFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val customFeedViewHolder = holder as? CustomFeedViewHolder
            val binding = customFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    HEADER_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return HeaderAdViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val headerAdViewHolder = holder as? HeaderAdViewHolder
            val binding = headerAdViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    IN_FEED_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return InFeedAdViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val inFeedAdViewHolder = holder as? InFeedAdViewHolder
            val binding = inFeedAdViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    },
    OFFICIAL_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return OfficialAdViewHolder(ItemOfficialAdViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener) {
            val officialAdViewHolder = holder as? OfficialAdViewHolder
            val binding = officialAdViewHolder?.binding as? ItemOfficialAdViewBinding
            binding?.also {
                it.listener = listener
                it.feedData = feedData
            }
        }
    };

    abstract fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData, listener: FeedAdapter.OnAdapterInteractionListener)

    companion object {

        @JvmStatic
        fun forOrder(order: Int): FeedCellType {
            for (cellTypes in FeedCellType.values()) {
                if (cellTypes.ordinal == order) {
                    return cellTypes
                }
            }
            throw IllegalArgumentException("no enum found for the order.")
        }
    }

    class FeedViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class SpecialFeedViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class LimitedFeedViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class CustomFeedViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class HeaderAdViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class InFeedAdViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class OfficialAdViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}