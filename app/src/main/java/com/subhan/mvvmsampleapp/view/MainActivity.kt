package com.subhan.mvvmsampleapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.subhan.mvvmsampleapp.viewModel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel=ViewModelProvider(this).get(HomeViewModel::class.java)
        setContent {
            HomePage(viewModel)
        }
    }
}
