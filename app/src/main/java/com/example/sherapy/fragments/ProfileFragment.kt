package com.example.sherapy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sherapy.R
import com.example.sherapy.databinding.FragmentProfileBinding
import com.example.sherapy.utilities.Dummy
import com.example.sherapy.utilities.ProfileAddOnsAdapter

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountAddOnAdapter = ProfileAddOnsAdapter()
        val helpDeskAddOnAdapter = ProfileAddOnsAdapter()

        binding.apply {
            rvAccountAddOn.apply {
                adapter = accountAddOnAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
            rvHelpdeskCenterAddOn.apply {
                adapter = helpDeskAddOnAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }

            accountAddOnAdapter.submitList(Dummy.getProfileAccountAddOns())
            helpDeskAddOnAdapter.submitList(Dummy.getProfileHelpdeskCenterAddOns())
        }

    }
}