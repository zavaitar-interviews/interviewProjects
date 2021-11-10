package com.zavaitar.beercraft.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zavaitar.beercraft.R
import com.zavaitar.beercraft.data.Beer

class BeerListAdapter(
    private val values: List<Beer>,
    private val callback: ItemSelectedListener?
) : RecyclerView.Adapter<BeerListAdapter.ViewHolder>(){

    private val onClickListener: View.OnClickListener = View.OnClickListener { view ->
        val item = view.tag as Beer
        callback?.onItemSelected(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.beer_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.tagline.text = item.tagline
        holder.imageView.load(item.imageUrl) {
            crossfade(true)
        }

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.item_name)
        val tagline: TextView = itemView.findViewById(R.id.item_tagline)
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
    }
}
