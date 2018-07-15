package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad

object AdUtil {

    fun getIncrementedIndex(index: Int, adListSize: Int): Int {
        var targetIndex = index
        targetIndex++
        if (targetIndex >= adListSize) {
            // 配列のサイズを超えたら0に戻す
            targetIndex = 0
        }
        return targetIndex
    }

    fun getNextLoadAdIndex(nextLoadAdOffset: Int, index: Int, adListSize: Int): Int {
        var targetIndex = index
        for (i in 0 until nextLoadAdOffset) {
            targetIndex = getIncrementedIndex(targetIndex, adListSize)
        }
        return targetIndex
    }
}
