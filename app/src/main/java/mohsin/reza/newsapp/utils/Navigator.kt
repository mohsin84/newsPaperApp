package mohsin.reza.newsapp.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Navigator {
    private var fragmentManager: FragmentManager? = null
    private var containerId: Int = -1

    fun bind(
        fragmentManager: FragmentManager,
        @IdRes containerId: Int
    ) {
        this.fragmentManager = fragmentManager
        this.containerId = containerId
    }

    fun unbind() {
        fragmentManager = null
        containerId = -1
    }

    private inline fun <reified T : Fragment> switchFragment(
        tag: String,
        changes: FragmentTransaction.() -> T
    ) {
        fragmentManager?.switchFragment(containerId, tag, changes, FragmentTransaction::replace)
    }
}