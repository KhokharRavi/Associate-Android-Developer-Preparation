package com.aad.prep.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aad.prep.R

class CoreAdapter(private val conceptList: List<String>, private val itemClickListener: ConceptItemClickListener) :
    RecyclerView.Adapter<CoreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreAdapter.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_core_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoreAdapter.ViewHolder, position: Int) {
        holder.textViewTitle.text = conceptList[position]
        holder.cardView.setOnClickListener {
            itemClickListener.itemClick(holder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        return conceptList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }


    interface ConceptItemClickListener{
        fun itemClick(position: Int)
    }
}