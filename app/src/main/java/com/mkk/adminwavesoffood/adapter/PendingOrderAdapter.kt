package com.mkk.adminwavesoffood.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mkk.adminwavesoffood.databinding.PendingOrderItemBinding

class PendingOrderAdapter(
    private val customerNames: ArrayList<String>,
    private val quantities: ArrayList<String>,
    private val orderImages: ArrayList<Int>,
    private val context: Context
) : RecyclerView.Adapter<PendingOrderAdapter.PendingOrderViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PendingOrderAdapter.PendingOrderViewHolder {
        return PendingOrderViewHolder(PendingOrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: PendingOrderAdapter.PendingOrderViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = customerNames.size

    inner class PendingOrderViewHolder(private val binding: PendingOrderItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var isAccepted = false
        fun bind(position: Int) {
            binding.apply {
                orderCustomerName.text = customerNames[position]
                orderImage.setImageResource(orderImages[position])
                orderQuantity.text = quantities[position]

                dispatchButton.apply {
                    if(!isAccepted){
                        text = "Accept"
                    }
                    else{
                        text = "Dispatch"
                    }

                    setOnClickListener {
                        if(!isAccepted){
                            text = "Dispatch"
                            isAccepted = true
                            showToast("Order is accepted successfully")
                        }
                        else{
                            customerNames.removeAt(adapterPosition)
                            notifyItemRemoved(adapterPosition)
                            showToast("Order is dispatched successfully")
                        }
                    }
                }
            }
        }

        private fun showToast(message: String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}