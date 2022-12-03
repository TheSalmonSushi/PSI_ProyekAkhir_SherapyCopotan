package com.example.sherapy.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.R
import com.example.sherapy.databinding.ActivityPembayaranBinding
import com.example.sherapy.databinding.PopupPembayaranBinding
import com.example.sherapy.utilities.PreferenceManager

class PembayaranActivity : Fragment() {

    private lateinit var binding: ActivityPembayaranBinding
    private lateinit var binding2: PopupPembayaranBinding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityPembayaranBinding.inflate(layoutInflater, container, false)

        binding.bayar.setOnClickListener {
            findNavController().navigate(PembayaranActivityDirections.actionPembayaranActivityToBayarSuccessActivity())
        }

        binding.upvote.setOnClickListener {
            findNavController().navigate(PembayaranActivityDirections.actionPembayaranActivityToPopupPembayaran())
        }
        return binding.root
    }
}