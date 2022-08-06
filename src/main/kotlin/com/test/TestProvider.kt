package com.test

import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.MainAPI

class TestProvider : MainAPI() {
    override var mainUrl = "https://example.com"
    override var name = "Test provider"
    override val supportedTypes = setOf(TvType.Movie)
}