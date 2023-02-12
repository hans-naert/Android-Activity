package com.example.androidactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidactivity.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_first)
        //val button1: Button =findViewById(R.id.button1)
        with(binding)
        {
            button1.setOnClickListener {
                Toast.makeText(this@FirstActivity, "You clicked Button 1", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
