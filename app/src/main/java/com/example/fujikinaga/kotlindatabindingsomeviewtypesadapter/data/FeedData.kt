package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data

import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.FeedCellType

data class FeedData(val feedCellType: FeedCellType, val userId: Int?, val feedId: Int?, val officialAdUrl: String?) {

    fun getLabel(): String {
        return feedCellType.name
    }
}