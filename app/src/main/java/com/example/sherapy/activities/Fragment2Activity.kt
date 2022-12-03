package com.example.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.activities.PembayaranActivityDirections
import com.example.sherapy.databinding.ActivityMainBinding
import com.example.sherapy.databinding.Fragment2Binding
import com.example.sherapy.databinding.FragmentProfileBinding
import com.example.sherapy.utilities.PreferenceManager

class Fragment2Activity : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(layoutInflater, container, false)
        binding.button5.setOnClickListener {
            findNavController().navigate(Fragment2ActivityDirections.actionFragment2ActivityToFragment3Activity())
        }
        return binding.root
    }
}