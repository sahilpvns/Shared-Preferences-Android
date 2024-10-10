package com.sahilpvns.sharedpreferencesandroid

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sahilpvns.sharedpreferencesandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)

        binding.loginButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.tvEmailID.text) && !TextUtils.isEmpty(binding.password.text)) {
                sharedPref.edit().apply {
                    putString("username", binding.tvName.text.toString())
                    putBoolean("isLoggedIn", true)
                    apply()
                }

                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Enter credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }
}