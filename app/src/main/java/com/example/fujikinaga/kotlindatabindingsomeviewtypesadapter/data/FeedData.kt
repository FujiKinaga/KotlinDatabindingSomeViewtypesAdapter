package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.data

import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.FeedCellType

data class FeedData(val feedCellType: FeedCellType) {

    fun getLabel(): String {
        return feedCellType.name
    }
}