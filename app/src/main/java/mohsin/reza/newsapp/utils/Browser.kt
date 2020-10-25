package mohsin.reza.newsapp.utils

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.browser.customtabs.CustomTabsIntent
import mohsin.reza.newsapp.App
import mohsin.reza.newsapp.R

object Browser {
    private val tabsIntent by lazy {
        val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            .setShowTitle(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            builder.setToolbarColor(App.app.getColor(R.color.colorPrimary))
        }
        builder.build()
    }

    fun openUrl(context: Context, url: String) {
        val uri = Uri.parse(url)
        tabsIntent.launchUrl(context, uri)
    }
}
