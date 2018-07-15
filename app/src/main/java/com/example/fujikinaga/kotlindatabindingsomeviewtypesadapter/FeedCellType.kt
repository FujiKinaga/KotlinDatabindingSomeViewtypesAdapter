package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data.FeedData
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.databinding.ItemFeedViewBinding

enum class FeedCellType {
    FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return FeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val feedViewHolder = holder as? FeedViewHolder
            val binding = feedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    SPECIAL_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return SpecialFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val specialFeedViewHolder = holder as? SpecialFeedViewHolder
            val binding = specialFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    LIMITED_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return LimitedFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val limitedFeedViewHolder = holder as? LimitedFeedViewHolder
            val binding = limitedFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    CUSTOM_FEED {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return CustomFeedViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val customFeedViewHolder = holder as? CustomFeedViewHolder
            val binding = customFeedViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    HEADER_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return HeaderAdViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val headerAdViewHolder = holder as? HeaderAdViewHolder
            val binding = headerAdViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    IN_FEED_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return InFeedAdViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val inFeedAdViewHolder = holder as? InFeedAdViewHolder
            val binding = inFeedAdViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    },
    OFFICIAL_AD {
        override fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder {
            return OfficialAdViewHolder(ItemFeedViewBinding.inflate(layoutInflater, parent, false))
        }

        override fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData) {
            val officialAdViewHolder = holder as? OfficialAdViewHolder
            val binding = officialAdViewHolder?.binding as? ItemFeedViewBinding
            binding?.also {
                it.feedData = feedData
            }
        }
    };

    abstract fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun initialize(holder: RecyclerView.ViewHolder, feedData: FeedData)

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