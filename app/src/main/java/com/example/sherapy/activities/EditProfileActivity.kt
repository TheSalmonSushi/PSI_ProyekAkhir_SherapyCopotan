package com.example.sherapy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sherapy.R
import com.example.sherapy.databinding.ActivityEditProfileBinding
import com.example.sherapy.utilities.Dummy
import com.example.sherapy.utilities.EditProfileAdapter
import com.example.sherapy.utilities.ProfileAddOnsAdapter

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDummyDariDB = listOf(
            "Dzikri Tampan & Berani",
            "dummy@gmail.com",
            "**********",
            "0812345678911",
            "12-12-2002",
            "Pengangguran Gaji 2 Digit"
        )

        binding.apply {
            ivEditNama.setOnClickListener {
                etValueNama.visibility = View.VISIBLE
                tvValueNama.visibility = View.INVISIBLE
                ivEditNama.setImageResource(R.drawable.calendar)

                ivEditNama.setOnClickListener {
                    saveData(etValueNama.text.toString())
                    ivEditNama.setImageResource(R.drawable.ic_baseline_edit_24)

                    tvValueNama.text = etValueNama.text
                    etValueNama.visibility = View.INVISIBLE
                    tvValueNama.visibility = View.VISIBLE
                }
            }
            ivEditEmail.setOnClickListener {
                etValueEmail.visibility = View.VISIBLE
                tvValueEmail.visibility = View.INVISIBLE
                ivEditEmail.setImageResource(R.drawable.calendar)

                ivEditEmail.setOnClickListener {
                    saveData(etValueEmail.text.toString())
                    ivEditEmail.setImageResource(R.drawable.ic_baseline_edit_24)

                    tvValueEmail.text = etValueEmail.text
                    etValueEmail.visibility = View.INVISIBLE
                    tvValueEmail.visibility = View.VISIBLE
                }
            }
        }

    }

    fun saveData(newData: String) {
        // SAVE DATA TO DATABASE
        Toast.makeText(this, "Saved $newData", Toast.LENGTH_LONG).show()
    }
}