package com.example.testnewsapp
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class NewsAdapter(val a: Activity, val articles: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsVH>() {
    class NewsVH(v: View) : RecyclerView.ViewHolder(v) {
        val title : TextView = v.findViewById(R.id.news_titile)
        val parent: CardView = v.findViewById(R.id.parent)
        val image: ImageView = v.findViewById(R.id.imageNews) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsVH {
val view = a.layoutInflater.inflate(R.layout.news_list_item,parent,false)
        return NewsVH(view) }

    override fun onBindViewHolder(holder: NewsAdapter.NewsVH, position: Int) {
        holder.title.text = articles[position].title

        val imageLink = articles[position].urlToImage
        Glide
            .with(a)
            .load(imageLink)
            .error(R.drawable.baseline_image_not_supported_24)
            .into(holder.image)

        val  articalink = articles[position].url
        holder.parent.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, articalink.toUri())
            a.startActivity(i) }
    }
    override fun getItemCount() = articles.size
}