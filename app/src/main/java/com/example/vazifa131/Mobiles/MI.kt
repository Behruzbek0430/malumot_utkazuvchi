package com.example.vazifa131.Mobiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vazifa131.R
import com.example.vazifa131.databinding.ActivityMainBinding
import com.example.vazifa131.databinding.ActivityMiBinding
import java.io.Serializable

class MI : AppCompatActivity() {
    lateinit var binding: ActivityMiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stringExtra = intent.getStringExtra("key") as Serializable
        binding.name.text = stringExtra.toString()

    }
}