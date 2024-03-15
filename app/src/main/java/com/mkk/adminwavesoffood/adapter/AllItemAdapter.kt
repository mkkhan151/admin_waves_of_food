package com.mkk.adminwavesoffood.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.adminwavesoffood.databinding.AllMenuItemBinding

class AllItemAdapter(
    private val menuItemNames: ArrayList<String>,
    private val menuItemPrices: ArrayList<String>,
    private val menuItemImages: ArrayList<Int>
): RecyclerView.Adapter<AllItemAdapter.AllItemViewHolder>() {

    private val itemQuantities = IntArray(menuItemNames.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        return AllItemViewHolder(AllMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() : Int = menuItemNames.size

    inner class AllItemViewHolder(
        private val binding: AllMenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodName.text = menuItemNames[position]
                foodPrice.text = menuItemPrices[position]
                itemQuantity.text = itemQuantities[position].toString()
                foodImage.setImageResource(menuItemImages[position])

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                removeItemButton.setOnClickListener {
                    deleteItem(position)
                }
            }
        }

        private fun deleteItem(position: Int) {
            menuItemNames.removeAt(position)
            menuItemPrices.removeAt(position)
            menuItemImages.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, menuItemNames.size)
        }

        private fun increaseQuantity(position: Int) {
            if(itemQuantities[position] < 10){
                itemQuantities[position]++
                binding.itemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if(itemQuantities[position] > 1){
                itemQuantities[position]--
                binding.itemQuantity.text = itemQuantities[position].toString()
            }
        }

    }
}