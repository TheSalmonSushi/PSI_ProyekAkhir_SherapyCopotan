package com.example.rpl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.activities.PembayaranActivityDirections
import com.example.sherapy.databinding.Fragment2Binding
import com.example.sherapy.databinding.Fragment3Binding
import com.example.sherapy.databinding.FragmentHomepageBinding
import com.example.sherapy.utilities.PreferenceManager

class Fragment3Activity : Fragment() {

    private lateinit var binding: Fragment3Binding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(layoutInflater, container, false)
        binding.button2.setOnClickListener {
            findNavController().navigate(Fragment3ActivityDirections.actionFragment3ActivityToFragment4Activity())
        }
        return binding.root
    }
}