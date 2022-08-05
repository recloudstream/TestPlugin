package com.test

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.nicehttp.Requests
import okhttp3.Interceptor
import kotlin.coroutines.Continuation

open class BaseApi {
    // These are still funky
    val app = Requests()

    open var name = "NONE"
    open var mainUrl = "NONE"
    open var storedCredentials: String? = null
    open var canBeOverridden: Boolean = true

    //open val uniqueId : Int by lazy { this.name.hashCode() } // in case of duplicate providers you can have a shared id

    open var lang = "en" // ISO_639_1 check SubtitleHelper

    /**If link is stored in the "data" string, so links can be instantly loaded*/
    open val instantLinkLoading = false

    /**Set false if links require referer or for some reason cant be played on a chromecast*/
    open val hasChromecastSupport = true

    /**If all links are encrypted then set this to false*/
    open val hasDownloadSupport = true

    /**Used for testing and can be used to disable the providers if WebView is not available*/
    open val usesWebView = false

    open val hasMainPage = false
    open val hasQuickSearch = false

    open val supportedTypes = setOf(
        TvType.Movie,
        TvType.TvSeries,
        TvType.Cartoon,
        TvType.Anime,
        TvType.OVA,
    )

    open val vpnStatus = VPNStatus.None
    open val providerType = ProviderType.DirectProvider

    open val mainPage = listOf(MainPageData("", ""))

    open fun getMainPage(
        page: Int,
        request: MainPageRequest,
    ): HomePageResponse? {
        throw NotImplementedError()
    }

    open fun search(query: String): List<SearchResponse>? {
        throw NotImplementedError()
    }

    open fun quickSearch(query: String): List<SearchResponse>? {
        throw NotImplementedError()
    }

    /**
     * Based on data from search() or getMainPage() it generates a LoadResponse,
     * basically opening the info page from a link.
     * */
    open fun load(url: String): LoadResponse? {
        throw NotImplementedError()
    }

    /**
     * Largely redundant feature for most providers.
     *
     * This job runs in the background when a link is playing in exoplayer.
     * First implemented to do polling for sflix to keep the link from getting expired.
     *
     * This function might be updated to include exoplayer timestamps etc in the future
     * if the need arises.
     * */
    open fun extractorVerifierJob(extractorData: String?) {
        throw NotImplementedError()
    }

    /**Callback is fired once a link is found, will return true if method is executed successfully*/
    open fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        throw NotImplementedError()
    }

    /** An okhttp interceptor for used in OkHttpDataSource */
    open fun getVideoInterceptor(extractorLink: ExtractorLink): Interceptor? {
        return null
    }


    inner class BaseObject : MainAPI() {
        override fun getLang(): String {
            return this@BaseApi.lang
        }

        override fun getMainUrl(): String {
            return this@BaseApi.mainUrl
        }

        override fun getMainPage(
            page: Int,
            request: MainPageRequest?,
            p2: Continuation<in HomePageResponse>?
        ): HomePageResponse? {
            return this@BaseApi.getMainPage(page, request!!)
        }

        override fun extractorVerifierJob(p0: String?, p1: Continuation<in Unit>?): Any {
            return this@BaseApi.extractorVerifierJob(p0)
        }

        override fun getCanBeOverridden(): Boolean {
            return this@BaseApi.canBeOverridden
        }

        override fun getHasChromecastSupport(): Boolean {
            return this@BaseApi.hasChromecastSupport
        }

        override fun getMainPage(): List<MainPageData> {
            return this@BaseApi.mainPage.toMutableList()
        }

        override fun getHasDownloadSupport(): Boolean {
            return this@BaseApi.hasDownloadSupport
        }

        override fun getProviderType(): ProviderType {
            return this@BaseApi.providerType
        }

        override fun getHasMainPage(): Boolean {
            return this@BaseApi.hasMainPage
        }

        override fun getHasQuickSearch(): Boolean {
            return this@BaseApi.hasQuickSearch
        }

        override fun getInstantLinkLoading(): Boolean {
            return this@BaseApi.instantLinkLoading
        }

        override fun getName(): String {
            return this@BaseApi.name
        }

        override fun getStoredCredentials(): String? {
            return this@BaseApi.storedCredentials
        }

        override fun getSupportedTypes(): Set<TvType> {
            return this@BaseApi.supportedTypes
        }

        override fun getUsesWebView(): Boolean {
            return this@BaseApi.usesWebView
        }

        override fun getVpnStatus(): VPNStatus {
            return this@BaseApi.vpnStatus
        }

        override fun getVideoInterceptor(p0: ExtractorLink): Interceptor? {
            return this@BaseApi.getVideoInterceptor(p0)
        }

        override fun load(p0: String, p1: Continuation<in LoadResponse>?): LoadResponse? {
            return this@BaseApi.load(p0)
        }

        override fun loadLinks(
            data: String,
            isCasting: Boolean,
            subtitleCallback: ((SubtitleFile) -> Unit),
            callback: ((ExtractorLink) -> Unit),
            p4: Continuation<in Boolean>?
        ): Boolean {
            return this@BaseApi.loadLinks(
                data,
                isCasting,
                subtitleCallback,
                callback,
            )
        }

        override fun setMainUrl(p0: String) {
            this@BaseApi.mainUrl = p0
        }

        override fun setCanBeOverridden(p0: Boolean) {
            this@BaseApi.canBeOverridden = p0
        }

        override fun quickSearch(
            p0: String,
            p1: Continuation<in MutableList<out SearchResponse>>?
        ): List<SearchResponse>? {
            return this@BaseApi.quickSearch(p0)
        }

        override fun setLang(p0: String) {
            this@BaseApi.lang = p0
        }

        override fun setName(p0: String) {
            this@BaseApi.name = p0
        }

        override fun setStoredCredentials(p0: String?) {
            this@BaseApi.storedCredentials = p0
        }

        override fun search(
            p0: String,
            p1: Continuation<in MutableList<out SearchResponse>>?
        ): List<SearchResponse>? {
            return this@BaseApi.search(p0)
        }
    }
}