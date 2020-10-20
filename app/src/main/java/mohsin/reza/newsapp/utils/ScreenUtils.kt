package mohsin.reza.newsapp.utils

import androidx.annotation.DimenRes
import mohsin.reza.newsapp.App

class ScreenUtils {
    companion object {
        val screenWidth
            get() = App.app.resources.displayMetrics.widthPixels

        val screenHeight
            get() = App.app.resources.displayMetrics.heightPixels

        val smallestWidthPx
            get() = screenHeight.coerceAtMost(screenWidth)

        fun getDimen(@DimenRes id: Int) = App.app.resources.getDimensionPixelSize(id)
    }
}
