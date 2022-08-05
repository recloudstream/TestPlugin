package com.test

import com.lagradost.cloudstream3.TvType

class TestProvider : BaseApi() {
    override var mainUrl = "https://example.com"
    override var name = "Test provider"
    override val supportedTypes = setOf(TvType.Movie)
}