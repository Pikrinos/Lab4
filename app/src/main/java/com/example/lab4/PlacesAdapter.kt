package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class PlacesAdapter(private val inflater: LayoutInflater): ListAdapter<MainActivity.Place, PlacesAdapter.ViewHolder>(PlaceDiffCallback) {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.p_name)
        private val address = view.findViewById<TextView>(R.id.p_address)

        fun bind(place: MainActivity.Place){
            name.text = place.name
            address.text = place.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = getItem(position)
        holder.bind(place)
    }

    object PlaceDiffCallback : DiffUtil.ItemCallback<MainActivity.Place>(){
        override fun areItemsTheSame(
            oldItem: MainActivity.Place,
            newItem: MainActivity.Place
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainActivity.Place,
            newItem: MainActivity.Place
        ): Boolean = oldItem.name == newItem.name && oldItem.address == newItem.address

    }
}