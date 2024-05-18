package com.mkk.adminwavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.adminwavesoffood.adapter.PendingOrderAdapter
import com.mkk.adminwavesoffood.databinding.ActivityPendingOrdersBinding

class PendingOrdersActivity : AppCompatActivity() {
    private val binding: ActivityPendingOrdersBinding by lazy {
        ActivityPendingOrdersBinding.inflate(layoutInflater)
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
        val quantities = arrayListOf("5", "2", "7")
        val orderImages = arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)

        val adapter = PendingOrderAdapter(customerNames, quantities, orderImages, this)
        binding.pendingOrdersRecyclerView.adapter = adapter
        binding.pendingOrdersRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}