package com.test

import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.Qualities
import org.jsoup.nodes.Element
import java.util.Collections
import java.util.HashSet
import java.util.Arrays

class TestProvider : MainAPI() {

    override fun getMainUrl(): String {
        return "https://example.com"
    }

    override fun getName(): String {
        return "Test provider"
    }

    override fun getSupportedTypes(): Set<TvType> {
        return HashSet(Arrays.asList(TvType.Movie))
    }    
}