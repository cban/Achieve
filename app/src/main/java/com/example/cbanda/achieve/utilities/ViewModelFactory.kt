package com.example.cbanda.achieve.utilities

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (private val mApplication: Application) : ViewModelProvider.Factory {

      @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelFactory(mApplication) as T
        }
    }
