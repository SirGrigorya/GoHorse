package com.example.gohorse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrdersAdapter(var orders: List<Order>, var context: Context): RecyclerView.Adapter<OrdersAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.orderImage)
        val title: TextView = view.findViewById(R.id.orderName)
        val desc: TextView = view.findViewById(R.id.orderDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = orders[position].title
        holder.desc.text = orders[position].desc

        val imageId = context.resources.getIdentifier(
            orders[position].image,
            "drawable",
            context.packageName
        )
        
        holder.image.setImageResource(imageId)
    }
}