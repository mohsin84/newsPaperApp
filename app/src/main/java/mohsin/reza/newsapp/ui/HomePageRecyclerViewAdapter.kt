package mohsin.reza.newsapp.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mohsin.reza.newsapp.network.model.Asset
import mohsin.reza.newsapp.utils.RecyclerViewAdapter

open class HomePageRecyclerViewAdapter(
    private val onClick: (Asset) -> Unit
) : RecyclerViewAdapter<Asset, ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleViewHolder(parent, onClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items?.get(position)?.let { shelveItem ->
            (holder as? ArticleViewHolder)?.updateModel(shelveItem)
        }
    }
}
