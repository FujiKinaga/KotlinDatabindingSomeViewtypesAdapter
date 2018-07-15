package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad

import android.content.Context
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.doubleclick.PublisherAdView

class TestBannerAdView constructor(context: Context) : AdView {

    private val publisherAdView = PublisherAdView(context)

    override val isLoading: Boolean
        get() = publisherAdView.isLoading

    override val view: View
        get() = publisherAdView

    init {
        publisherAdView.setAdSizes(AdSize.BANNER)
        publisherAdView.adUnitId = "/6499/example/banner"
    }

    override fun resume() {
        publisherAdView.resume()
    }

    override fun pause() {
        publisherAdView.pause()
    }

    override fun destroy() {
        publisherAdView.destroy()
    }

    override fun load(callback: AdView.Callback?) {
        publisherAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                callback?.onSuccess()
                // 広告が見えたまましばらく停滞すると広告のコンテンツが更新されてこのコールバックが呼ばれるため、初めの一回しかコールバックを呼ばない
                publisherAdView.adListener = null
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                callback?.onFailure(errorCode)
                publisherAdView.adListener = null
            }
        }
        publisherAdView.loadAd(PublisherAdRequest.Builder().build())
    }
}