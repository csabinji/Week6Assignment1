package com.sabin.softuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sabin.softuser.R
import com.sabin.softuser.model.User

class UserAdapter(
        val lstUser : ArrayList<User>,
        val context: Context
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName : TextView
        val tvAge : TextView
        val tvAddress : TextView
        val tvGender : TextView
        val imgProfile : ImageView
        val dlt : ImageView
        init {
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            imgProfile = view.findViewById(R.id.imgProfile)
            dlt = view.findViewById(R.id.dlt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstUser[position]
        holder.tvName.text = user.fullName
        holder.tvAge.text = user.Age.toString()
        holder.tvAddress.text = user.Address
        holder.tvGender.text = user.Gender
        holder.dlt.setOnClickListener {
            lstUser.removeAt(position)
            notifyDataSetChanged()
        }

        Glide.with(context)
            .load(user.Img)
            .into(holder.imgProfile)

    }

    override fun getItemCount(): Int {
        return lstUser.size
    }
}