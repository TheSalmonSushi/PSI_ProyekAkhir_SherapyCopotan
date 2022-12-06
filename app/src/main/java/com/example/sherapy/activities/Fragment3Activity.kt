package com.example.sherapy.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.databinding.Fragment3Binding
import com.example.sherapy.utilities.PreferenceManager

class Fragment3Activity : Fragment() {

    private lateinit var binding: Fragment3Binding
    private lateinit var preferenceManager: PreferenceManager
    lateinit var performance:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment3Binding.inflate(layoutInflater, container, false)
        performance=binding.performance

        binding.button2.setOnClickListener {
            findNavController().navigate(Fragment3ActivityDirections.actionFragment3ActivityToFragment4Activity())
        }
        val args = this.arguments
        val correctAnsNo = args?.getString("correct")
        val totalAnsNo = args?.getString("total")

        val percentage= (correctAnsNo?.toFloat()?.div(totalAnsNo?.toFloat()!!))?.times(100)

        if (percentage != null) {
            when {
                (percentage > 50) && (percentage < 99) -> {
                    "GOOD".also { performance.text = it }
                }
                percentage >= 100 -> {
                    "EXCELLENT".also { performance.text = it }
                }
                percentage < 50 -> {
                    "POOR".also { performance.text = it }
                }
            }
        }
        binding.percent.text = "60%"
            return binding.root
    }
}