package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.databinding.FragmentSettingsScreenBinding
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel


class SettingsScreenFragment: Fragment() {

    private lateinit var binding: FragmentSettingsScreenBinding
    private val model: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentSettingsScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEditTextValidation(model)
        setupSwitchLogic(model)
        setupButtons(model)
    }

    private fun setupButtons(model: SharedViewModel) {
        binding.demoInformationBtn.setOnClickListener {

            //Start activity
            val informativeScreenFragment: Fragment = InformativeScreenFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,informativeScreenFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.launchDemoBtn.setOnClickListener {
            if (model.isAllInputValid()) {
                //Start activity
            } else {
                Toast.makeText(requireContext(), "You have not filled out all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupEditTextValidation(model: SharedViewModel) {

        binding.publisherEt.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    when(model.isTextValid(p0)) {
                        false -> binding.publisherEt.error = "Your input is wrong"
                        true -> model.setUserInput(binding.publisherEt.id, p0.toString())
                    }
                }
            }
        })

        binding.apiKeyEt.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    when(model.isTextValid(p0)) {
                        false -> binding.apiKeyEt.error = "Your input is wrong"
                        true -> model.setUserInput(binding.apiKeyEt.id, p0.toString())
                    }
                }
            }
        })
    }

    private fun setupSwitchLogic(model: SharedViewModel) {
        binding.preloadSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            model.setSwitchCheckedStatus(compoundButton.id, isChecked)
            binding.lazyLoadSwitch.isClickable = !model.isPreloadSwitchChecked()

        }
        binding.lazyLoadSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            model.setSwitchCheckedStatus(compoundButton.id, isChecked)
            binding.preloadSwitch.isClickable = !model.isLazyLoadChecked()
        }
    }
}