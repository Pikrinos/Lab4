package com.example.lab4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class old_PlacesAdapter(private val list: MutableList<MainActivity.Place>, private val inflater: LayoutInflater) : BaseAdapter() {

    private data class ViewHolder(val name: TextView, val address: TextView)

    override fun getCount(): Int = list.size

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: inflater.inflate(R.layout.list_item, p2,false).also {
            val name = it.findViewById<TextView>(R.id.p_name)
            val address = it.findViewById<TextView>(R.id.p_address)
            val holder = ViewHolder(name, address)
            it.tag = holder
        }

        val holder = view.tag as ViewHolder
        holder.name.text = list[p0].name
        holder.address.text = list[p0].address

        return view
    }

    override fun getItem(p0: Int): Any = list[p0]
    override fun getItemId(p0: Int): Long = 0
}