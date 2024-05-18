package com.mkk.adminwavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mkk.adminwavesoffood.databinding.ActivityAdminProfileBinding

class AdminProfileActivity : AppCompatActivity() {
    private val binding: ActivityAdminProfileBinding by lazy {
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.adminName.isEnabled = false
        binding.adminAddress.isEnabled = false
        binding.adminEmail.isEnabled = false
        binding.adminPhone.isEnabled = false
        binding.adminPassword.isEnabled = false

        var isEnabled = false
        binding.editButton.setOnClickListener {
            isEnabled = !isEnabled
            binding.adminName.isEnabled = isEnabled
            binding.adminAddress.isEnabled = isEnabled
            binding.adminEmail.isEnabled = isEnabled
            binding.adminPhone.isEnabled = isEnabled
            binding.adminPassword.isEnabled = isEnabled

            if(isEnabled){
                binding.adminName.requestFocus()
            }
        }
    }
}