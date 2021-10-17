package com.example.rss

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rss.databinding.ItemBinding

class RVAdapter(val list: ArrayList<RVData>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
            holder.binding.tvtitle.text = item.title
           holder.binding.tvDescription.text = item.description

        val linkHolder = holder.binding.tvLink
        val htmlString = "<a href = '${item.link}'>Read More</a>"
        val spanned = HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY)
        linkHolder.movementMethod = LinkMovementMethod.getInstance()
        linkHolder.text = spanned






    }

    override fun getItemCount(): Int {
        return list.size
    }
}