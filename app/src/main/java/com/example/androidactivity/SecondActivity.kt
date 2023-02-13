package com.example.androidactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_first)
        //val button1: Button =findViewById(R.id.button1)
        with(binding)
        {
            button2.setOnClickListener {
                val intent = Intent()
                intent.putExtra("data_return", "Hello FirstActivity")
                setResult(RESULT_OK, intent)
                finish()

            }
        }
    }
}