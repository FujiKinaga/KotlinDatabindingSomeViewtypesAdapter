package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import java.util.*

private const val AD_LIST_SIZE = 5
private const val AD_INITIAL_LOAD_LIMIT_SIZE = 3
private const val AD_NEXT_LOAD_INDEX_OFFSET = 2
private const val AD_INVALID_INDEX = -1

class AdViewModel : ViewModel(), LifecycleObserver {

    private lateinit var adViewList: MutableList<AdView>

    private var shouldReturnAdIndex = AD_INVALID_INDEX

    // +1したインデックスに入っているAdViewを返したいのでインクリメント
    // バインドされるときにそのインデックスから2個先を先読みする(同じ広告が見えてしまうのを防ぐ)
    val adViewForBindToAdapter: AdView
        get() {
            shouldReturnAdIndex = AdUtil.getIncrementedIndex(shouldReturnAdIndex, AD_LIST_SIZE)
            val shouldLoadAdIndexForPrefetch = AdUtil.getNextLoadAdIndex(AD_NEXT_LOAD_INDEX_OFFSET, shouldReturnAdIndex, AD_LIST_SIZE)
            loadAdForPrefetch(adViewList, shouldLoadAdIndexForPrefetch)

            return adViewList[shouldReturnAdIndex]
        }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        for (adView in adViewList) {
            adView.resume()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        for (adView in adViewList) {
            adView.pause()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        for (adView in adViewList) {
            adView.destroy()
        }
    }

    fun initAdViewList(context: Context) {
        adViewList = ArrayList(AD_LIST_SIZE)
        for (i in 0 until AD_LIST_SIZE) {
            val adView: AdView = TestBannerAdView(context)
            adViewList.add(adView)
        }
        startInitialLoad(adViewList)
    }

    private fun startInitialLoad(adViewList: MutableList<AdView>) {
        loadAdForInitialize(adViewList, 0)
    }

    private fun loadAdForInitialize(adViewList: MutableList<AdView>, adLoadCount: Int) {
        if (adLoadCount >= AD_INITIAL_LOAD_LIMIT_SIZE) {
            // 初回は広告Viewが真っ白になる状態を防ぐため、3広告分を先に読み込むようにする
            return
        }
        val adView = adViewList[adLoadCount]
        adView.load(object : AdView.Callback {
            override fun onSuccess() {
                loadAdForInitialize(adViewList, adLoadCount + 1)
            }

            override fun onFailure(errorCode: Int) {
                loadAdForInitialize(adViewList, adLoadCount + 1)
            }
        })
    }

    private fun loadAdForPrefetch(adViewList: MutableList<AdView>, targetIndex: Int) {
        val adView = adViewList[targetIndex]
        if (adView.isLoading) {
            // 読み込み中ならスキップ
            return
        }
        adView.load(object : AdView.Callback {
            override fun onSuccess() {
                // この場合は一つだけ読み込みたいので何もしない
            }

            override fun onFailure(errorCode: Int) {}
        })
    }
}