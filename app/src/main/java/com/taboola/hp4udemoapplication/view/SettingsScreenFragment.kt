package com.taboola.hp4udemoapplication.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.databinding.FragmentSettingsScreenBinding
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel


class SettingsScreenFragment : Fragment() {

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
        setupDefaultConfiguration(model)
        setupEditTextValidation(model)
        setupSwitchLogic(model)
        setupButtons(model)
    }

    private fun setupDefaultConfiguration(model: SharedViewModel) {
        binding.publisherEt.setText(HP4UDemoConstants.DEFAULT_PUBLISHER_NAME)
        binding.apiKeyEt.setText(HP4UDemoConstants.DEFAULT_API_KEY)
        model.setUserInput(binding.publisherEt.id, HP4UDemoConstants.DEFAULT_PUBLISHER_NAME)
        model.setUserInput(binding.apiKeyEt.id, HP4UDemoConstants.DEFAULT_API_KEY)
    }

    private fun setupButtons(model: SharedViewModel) {
        binding.demoInformationBtn.setOnClickListener {
            model.switchFragment(requireActivity(), InformativeScreenFragment())
        }

        binding.launchDemoBtn.setOnClickListener {
            if (model.isAllInputValid()) {
                model.switchFragment(requireActivity(), HomePageScreenFragment())
            } else {
                showEmptyFieldsAlertDialog()
            }
        }
    }

    private fun showEmptyFieldsAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage("Please fill in all required fields")
            .setNeutralButton("Ok", DialogInterface.OnClickListener {dialogInterface, i ->
                dialogInterface.dismiss()
            })
            .show()
    }

    private fun setupEditTextValidation(model: SharedViewModel) {

        binding.publisherEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    model.setUserInput(binding.publisherEt.id, p0.toString())
                }
            }
        })

        binding.apiKeyEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                     model.setUserInput(binding.apiKeyEt.id, p0.toString())
                }
            }
        })
    }

    /**
     * Only one switch can be active at a time
     * So when one of the switches is pressed, the other one is turned off
     */
    private fun setupSwitchLogic(model: SharedViewModel) {
        binding.preloadSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            compoundButton.isChecked = isChecked
            binding.lazyLoadSwitch.isChecked = !isChecked
            model.setSwitchCheckedStatus(compoundButton.id, isChecked)
        }

        binding.lazyLoadSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            compoundButton.isChecked = isChecked
            binding.preloadSwitch.isChecked = !isChecked
            model.setSwitchCheckedStatus(compoundButton.id, isChecked)
        }

        //Default setting is Preload should be checked
        binding.preloadSwitch.isChecked = true
    }

    override fun onResume() {
        super.onResume()
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        model.setToolbarTitle(requireActivity(), "Demo Settings")
        model.setToolbarTitleTextAppearance(toolbar, R.style.RobotTextAppearance)
    }
}