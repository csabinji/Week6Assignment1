package com.sabin.softuser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.sabin.softuser.R
import com.sabin.softuser.model.User
import com.sabin.softuser.model.userList

class AddFragment : Fragment(),View.OnClickListener {

    private lateinit var name : EditText
    private lateinit var age : EditText
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var others : RadioButton
    private lateinit var address : EditText
    private lateinit var image : EditText
    private lateinit var Save : Button

    private var gender = ""

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
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        name = view.findViewById(R.id.name)
        age = view.findViewById(R.id.age)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        others = view.findViewById(R.id.others)
        address = view.findViewById(R.id.address)
        image = view.findViewById(R.id.image)
        Save = view.findViewById(R.id.Save)

        Save.setOnClickListener(this)

        male.setOnClickListener {
            gender = "Male"
        }
        female.setOnClickListener {
            gender = "Female"
        }

        others.setOnClickListener {
            gender = "Others"
        }

        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.Save ->{
                userList.addUser(User(name.text.toString(), age.text.toString().toInt(),gender,address.text.toString(),image.text.toString()))
            }
    }


}

}