package com.ory.stark.esigntesttask.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ory.stark.esigntesttask.R

/**
 * Created by Oryna Starkina on 12.01.2022.
 * Email: oryna.stark@gmail.com
 */
class RecentActionsAdapter(var recentActions: ArrayList<RecentAction> = ArrayList()) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_fragment_recent_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindItem(recentActions[position])

    override fun getItemCount(): Int = recentActions.size
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindItem(action: RecentAction) {
        this.itemView.findViewById<TextView>(R.id.recent_actions_document_title).text =
            action.documentTitle
        this.itemView.findViewById<ImageView>(R.id.recent_actions_icon)
            .setImageResource(action.status.icon)
        this.itemView.findViewById<TextView>(R.id.recent_actions_document_status)
            .setText(action.status.title)
    }
}