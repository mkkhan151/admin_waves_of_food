package com.mkk.adminwavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.mkk.adminwavesoffood.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationList = listOf("Mardan", "Peshawar", "Lahore", "Islamabad")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locationList)
        binding.listOfLocation.setAdapter(adapter)

        binding.alreadyHaveAccountButton.setOnClickListener {
            finish()
        }

        binding.createAccountButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}