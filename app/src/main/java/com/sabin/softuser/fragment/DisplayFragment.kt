package com.sabin.softuser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabin.softuser.R
import com.sabin.softuser.adapter.UserAdapter
import com.sabin.softuser.model.userList

class DisplayFragment : Fragment() {

    private lateinit var RvHome : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_display, container, false)
        RvHome = view.findViewById(R.id.RvHome)
        val adapter = UserAdapter(userList.showUser(),context!!)
        RvHome.layoutManager = LinearLayoutManager(context!!)
        RvHome.adapter = adapter

        return view
    }



}