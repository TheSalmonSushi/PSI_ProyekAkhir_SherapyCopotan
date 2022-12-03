package com.example.sherapy.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.activities.Fragment2Activity
import com.example.sherapy.R
import com.example.sherapy.activities.KonselDetailActivity
import com.example.sherapy.databinding.ActivityKonselingBinding
import com.example.sherapy.databinding.ActivityMainBinding
import com.example.sherapy.databinding.Fragment1Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Fragment1Activity : Fragment() {

    private lateinit var _binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(layoutInflater)
        viewLifecycleOwner.lifecycleScope.launch {
            delay(5000)
            findNavController().navigate(Fragment1ActivityDirections.actionFragment1FragmentToFragment2Activity())
        }
        return _binding.root
    }

}