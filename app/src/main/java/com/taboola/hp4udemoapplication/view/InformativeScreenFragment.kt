package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taboola.hp4udemoapplication.databinding.FragmentInformativesScreenBinding


class InformativeScreenFragment : Fragment() {

    private lateinit var binding: FragmentInformativesScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentInformativesScreenBinding.inflate(layoutInflater, container, false)

        //Making the textView scrollable
        binding.informativeTv.movementMethod = ScrollingMovementMethod()
        return binding.root
    }
}