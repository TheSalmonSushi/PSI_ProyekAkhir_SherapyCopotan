package com.example.sherapy.utilities

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sherapy.activities.EditProfileActivity
import com.example.sherapy.databinding.ItemProfileLayoutBinding

class ProfileAddOnsAdapter: RecyclerView.Adapter<ProfileAddOnsAdapter.ProfileAddOnsViewHolder>() {

    private val list = arrayListOf<Pair<Int, String>>()

    fun submitList(data: List<Pair<Int, String>>) {
        list.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    class ProfileAddOnsViewHolder(val view: ItemProfileLayoutBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(data: Pair<Int, String>) {
            view.apply {
                ivIcon.setImageResource(data.first)
                tvAction.text = data.second
            }
            itemView.setOnClickListener {
                if (data.second == "Edit Profile") {
                    val intent = Intent(itemView.context, EditProfileActivity::class.java)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAddOnsViewHolder {
        val view = ItemProfileLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileAddOnsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileAddOnsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}