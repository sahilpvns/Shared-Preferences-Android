package com.sahilpvns.sharedpreferencesandroid

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sahilpvns.sharedpreferencesandroid.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")

        binding.tvUserName.text = username

        binding.logoutButton.setOnClickListener {
            sharedPref.edit().apply {
                putBoolean("isLoggedIn", false)
                apply()
            }

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}