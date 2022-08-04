package com.test

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import com.lagradost.cloudstream3.APIHolder
import android.content.Context
import android.widget.Toast

@CloudstreamPlugin
class TestPlugin: Plugin() {
    
    override fun load(context: Context) {
        APIHolder.INSTANCE.allProviders.add(TestProvider())
    }
}