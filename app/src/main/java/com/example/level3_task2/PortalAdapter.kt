package com.example.level3_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*


class PortalAdapter (private val portals: List<Portal>, val clickListener: (Portal) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal, clickListener: (Portal) -> Unit) {
            itemView.tvPortalName.text = portal.portalName
            itemView.tvPortalUrl.text = portal.portalUrl
            itemView.setOnClickListener { clickListener(portal)}
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(portals[position], clickListener)
    }

}