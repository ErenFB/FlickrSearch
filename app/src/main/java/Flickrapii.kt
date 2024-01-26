package com.example.onboardingcompose

import android.util.Log

class Flickrapii() {
    fun fetchInterestPhotos() {
        //url request
        val url = constructInterests()
        Log.d(TAG, "Fetchs : $url")
    }

    fun constructInterests(): String {
        var url = BASE_URL
        url += "?method=flickr.interestingness.getList"
        url += "api_key=" + API_KEY
        url += "&format=json"
        url += "&nojsoncallback=1"
        url += "&extras=date_taken,url+h"
        return url
    }

    companion object {
        const val BASE_URL = "https://api.flickr.com/services/rest"
        const val API_KEY = "d1a5c80dce4a990cd6d12fed8f23f83a"
        const val TAG = "WebServicesFunTag"
    }
}