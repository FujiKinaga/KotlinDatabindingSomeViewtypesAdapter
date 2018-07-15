package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad

import android.view.View

interface AdView {

    val isLoading: Boolean

    val view: View

    fun resume()

    fun pause()

    fun destroy()

    fun load(callback: Callback?)

    interface Callback {

        fun onSuccess()

        fun onFailure(errorCode: Int)
    }
}