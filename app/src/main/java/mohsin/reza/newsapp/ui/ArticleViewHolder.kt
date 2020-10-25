package mohsin.reza.newsapp.ui

import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_item.view.*
import mohsin.reza.newsapp.R
import mohsin.reza.newsapp.di.GlideApp
import mohsin.reza.newsapp.network.model.Asset
import mohsin.reza.newsapp.utils.ViewHolder
import timber.log.Timber

class ArticleViewHolder constructor(
    parent: ViewGroup,
    private val onClick: (Asset) -> Unit
) : ViewHolder<Asset>(parent, R.layout.item_article_item) {

    private val articleImageView: ImageView
        get() = itemView.article_image_view

    init {
        itemView.setOnClickListener { onClick(model) }
    }

    override fun onRefreshView(model: Asset) {
        itemView.headline_text_view.text = model.headline ?: ""
        itemView.abstract_text_view.text = model.theAbstract ?: ""
        itemView.by_line_text_view.text = "- ".plus(model.byLine ?: "")
    }

    override fun onAttach() {
        super.onAttach()
        val imageUrl = model.imageUrl ?: ""
        Timber.d("imageUrl=$imageUrl")
        GlideApp.with(articleImageView)
            .load(imageUrl)
            .centerCrop()
            .fallback(R.drawable.place_holder_tile)
            .error(R.drawable.place_holder_tile)
            .into(articleImageView)
    }

    override fun onDetach() {
        super.onDetach()
        Glide.with(context).clear(articleImageView)
    }
}