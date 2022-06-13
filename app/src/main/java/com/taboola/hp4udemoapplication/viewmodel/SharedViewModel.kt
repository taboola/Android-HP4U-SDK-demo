package com.taboola.hp4udemoapplication.viewmodel

import android.text.Editable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.taboola.hp4udemoapplication.R

class SharedViewModel: ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = ""
    private var apiKey: String = ""

    fun setSwitchCheckedStatus(switchId: Int, checkedState: Boolean) {
        when(switchId) {
            R.id.preload_switch -> isPreloadChecked = checkedState
            R.id.lazy_load_switch -> isLazyLoadChecked = checkedState
        }
    }

    fun isPreloadSwitchChecked(): Boolean {
        return isPreloadChecked
    }

    fun isLazyLoadChecked(): Boolean {
        return isLazyLoadChecked
    }

    fun setUserInput(editTextId: Int, input: String) {
        when(editTextId) {
            R.id.publisher_et -> publisherName = input
            R.id.api_key_et -> apiKey = input
        }
    }

    fun isTextValid(editable: Editable): Boolean {
        val text: String = editable.toString()
        return text.isNotEmpty() && text.contains(regex = Regex("^[a-zA-Z]+$"))
    }

    fun isAllInputValid(): Boolean {
        //One switch must be checked
        if (!isPreloadChecked && !isLazyLoadChecked) {
            return false
        }

        if (publisherName.isEmpty() || apiKey.isEmpty()) {
            return false
        }

        return true
    }

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment){
        fragmentActivity.supportFragmentManager.beginTransaction().replace(R.id.container,fragmentToSwitch).commit()
    }
}