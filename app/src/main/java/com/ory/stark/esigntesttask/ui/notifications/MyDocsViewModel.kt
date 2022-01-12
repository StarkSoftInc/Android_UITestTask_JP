package com.ory.stark.esigntesttask.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyDocsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is My Docs"
    }
    val text: LiveData<String> = _text
}