package com.example.androidactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
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
        val button1: Button =findViewById(R.id.button1)
        //with(binding)
        //{
            button1.setOnClickListener {
                //val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                //val intent = Intent("com.example.androidactivity.ACTION_START")
                //intent.addCategory("com.example.androidactivity.MY_CATEGORY")
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data=Uri.parse("http://www.vives.be")
                //intent.setType("text/html")
                startActivity(intent)
                /*intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(Intent.createChooser(intent, "Choose browser"))
                } else {
                    // No activities can handle the intent
                    Log.v("Intent","No activities can handle the intent")
                }*/
            }
        //}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add",
                Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
