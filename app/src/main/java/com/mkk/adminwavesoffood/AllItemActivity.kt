package com.mkk.adminwavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.adminwavesoffood.adapter.AllItemAdapter
import com.mkk.adminwavesoffood.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        val foodNames = arrayListOf("Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab")
        val foodPrices = arrayListOf("$ 35", "$ 35", "$ 35", "$ 35", "$ 35", "$ 35")
        val foodImages = arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)

        val adapter = AllItemAdapter(foodNames, foodPrices, foodImages)
        binding.allItemRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allItemRecyclerView.adapter = adapter
    }
}