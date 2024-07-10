package com.example.gohorse

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class OrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_orders)

        val orderList: RecyclerView = findViewById(R.id.orderList)
        val orders = arrayListOf<Order>()

        orders.add(Order(1, "Бочка", "Записаться на бочку", "zzz"))
        orders.add(Order(2, "Занятие с тренером", "Записаться на занятие", "zzz"))
        orders.add(Order(3, "wip", "wip", "zzz"))

        orderList.layoutManager = LinearLayoutManager(this)
        orderList.adapter = OrdersAdapter(orders, this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}