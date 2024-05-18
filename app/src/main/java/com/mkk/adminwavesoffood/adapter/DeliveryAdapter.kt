package com.mkk.adminwavesoffood.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.adminwavesoffood.databinding.DeliveryItemBinding

class DeliveryAdapter(
    private val customerNames: ArrayList<String>,
    private val paymentStatuses: ArrayList<String>
) : RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        return DeliveryViewHolder(
            DeliveryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = customerNames.size

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class DeliveryViewHolder(private val binding: DeliveryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                customerName.text = customerNames[position]
                paymentStatus.text = paymentStatuses[position]
                val colorMap = mapOf(
                    "received" to Color.GREEN,
                    "notReceived" to Color.RED,
                    "pending" to Color.GRAY
                )
                paymentStatus.setTextColor(colorMap[paymentStatuses[position]]?:Color.BLACK)
                deliveryStatus.backgroundTintList = ColorStateList.valueOf(colorMap[paymentStatuses[position]]?:Color.BLACK)
            }
        }

    }
}