package com.example.androidactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidactivity.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    var number= 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_first)
        //val button1: Button =findViewById(R.id.button1)
        with(binding)
        {
            if(savedInstanceState!=null) {
                number = savedInstanceState.getInt("number")
                textView.text=number.toString()
            }
            button1.setOnClickListener {
                val data = "Hello SecondActivity"
                val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                intent.putExtra("extra_data", data)
                startActivityForResult(intent,1)
            }

            incrementVariableButton.setOnClickListener {
                number++;
                textView.text=number.toString();
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("number", number)
    }

    private val tag = "FirstActivity"
    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
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

    override fun onActivityResult(requestCode: Int, resultCode:
    Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }
}
