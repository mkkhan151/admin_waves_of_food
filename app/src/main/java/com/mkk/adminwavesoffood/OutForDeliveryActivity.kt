package com.mkk.adminwavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.adminwavesoffood.adapter.DeliveryAdapter
import com.mkk.adminwavesoffood.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private val binding: ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        val customerNames = arrayListOf(
            "John Doe",
            "Jane Smith",
            "Mike Johnson"
        )
        val paymentStatuses = arrayListOf(
            "received",
            "notReceived",
            "pending"
        )

        val adapter = DeliveryAdapter(customerNames, paymentStatuses)
        binding.deliveryRecyclerView.adapter = adapter
        binding.deliveryRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}