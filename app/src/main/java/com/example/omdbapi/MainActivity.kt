package com.example.omdbapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.omdbapi.databinding.ActivityMainBinding
import com.example.omdbapi.fragment.DataFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        showFragment()
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataFragment()


        mFragmentTransaction.add(R.id.fl_data,mFragment).commit()
    }
}