package com.example.sherapy.utilities

import com.example.sherapy.R

object Dummy {

    fun getProfileAccountAddOns() = listOf(
        Pair(0, "Edit Profile"),
        Pair(0, "Payment History"),
        Pair(0, "Saved"),
        Pair(0, "Change Language"),
        Pair(0, "Log Out")
    )

    fun getProfileHelpdeskCenterAddOns() = listOf(
        Pair(0, "Privacy Policy"),
        Pair(0, "Customer Service"),
        Pair(0, "Frequently Asked Question")
    )

    fun getEditProfile() = listOf(
        Pair(R.drawable.calendar, "Nama"),
        Pair(0, "Email"),
        Pair(0, "Password"),
        Pair(0, "Nomor Handphone"),
        Pair(0, "Tanggal Lahir"),
        Pair(0, "Pekerjaan")
    )

}