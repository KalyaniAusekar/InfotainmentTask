package com.example.infotainmenttask.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infotainmenttask.MainActivity
import com.example.infotainmenttask.R
import com.google.android.material.button.MaterialButton

class OtpConfirmFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_otp_confirm, container, false)

        val btn_submit_otp = view.findViewById<MaterialButton>(R.id.btn_otp_submit)
        btn_submit_otp.setOnClickListener {

            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)

        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDetach()
    }
}