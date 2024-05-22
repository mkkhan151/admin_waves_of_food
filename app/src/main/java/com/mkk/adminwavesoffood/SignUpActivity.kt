package com.mkk.adminwavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.mkk.adminwavesoffood.databinding.ActivitySignUpBinding
import com.mkk.adminwavesoffood.model.UserModel

class SignUpActivity : AppCompatActivity() {
    private lateinit var userName: String
    private lateinit var restaurantName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private val binding : ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initialize firebase auth
        auth = Firebase.auth

        // initialize data
        database = Firebase.database.reference

        val locationList = listOf("Mardan", "Peshawar", "Lahore", "Islamabad")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locationList)
        binding.listOfLocation.setAdapter(adapter)

        binding.alreadyHaveAccountButton.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.createAccountButton.setOnClickListener {
            userName = binding.ownerName.text.toString().trim()
            restaurantName = binding.restaurantName.text.toString().trim()
            email = binding.signUpEmail.text.toString().trim()
            password = binding.signUpPassword.text.toString().trim()

            if(userName.isBlank() || restaurantName.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
            else{
                createAccount(email, password)
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure", task.exception)
            }
        }
    }

    private fun saveUserData() {
//        save data into firebase database
        userName = binding.ownerName.text.toString().trim()
        restaurantName = binding.restaurantName.text.toString().trim()
        email = binding.signUpEmail.text.toString().trim()
        password = binding.signUpPassword.text.toString().trim()
        val user = UserModel(userName, restaurantName, email, password)
        val userId: String = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)
            .addOnSuccessListener {
                Log.d("Database", "User data saved successfully")
                // Handle success
            }
            .addOnFailureListener {
                Log.e("Database", "Failed to save user data", it)
                // Handle failure
            }
    }
}