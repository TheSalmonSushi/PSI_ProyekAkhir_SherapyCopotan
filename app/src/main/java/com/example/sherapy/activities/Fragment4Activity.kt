package com.example.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.activities.PembayaranActivityDirections
import com.example.sherapy.databinding.Fragment3Binding
import com.example.sherapy.databinding.Fragment4Binding
import com.example.sherapy.utilities.PreferenceManager

class Fragment4Activity : Fragment() {

    private lateinit var binding: Fragment4Binding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment4Binding.inflate(layoutInflater, container, false)
        binding.imageButton3.setOnClickListener {
            findNavController().navigate(Fragment4ActivityDirections.actionMoodFragmentToHomepageFragment())
        }
        return binding.root
    }
}