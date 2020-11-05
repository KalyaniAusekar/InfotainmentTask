package com.example.infotainmenttask.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.infotainmenttask.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_start_withbasics.*


class StartWithbasicsFragment : Fragment() {

    private var edtfirstname: TextInputEditText? = null
    private var edtlastname: TextInputEditText? = null
    private var edtusername: TextInputEditText? = null
    private var btnnextsignUp: MaterialButton? = null

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_withbasics, container, false)

        sharedPreferences = context!!.getSharedPreferences("MY_PREF",Context.MODE_PRIVATE)

        edtfirstname = view.findViewById<TextInputEditText>(R.id.edt_user_first_name) as TextInputEditText
        edtlastname = view.findViewById<TextInputEditText>(R.id.edt_user_last_name) as TextInputEditText
        edtusername = view.findViewById<TextInputEditText>(R.id.edt_username_signup) as TextInputEditText

        btnnextsignUp = view.findViewById<MaterialButton>(R.id.btn_next_signup_screen) as MaterialButton

        btnnextsignUp!!.setOnClickListener {

            /*if (edtfirstname!!.text?.trim().toString().isNotEmpty() || edtlastname!!.text?.trim().toString().isNotEmpty() ||
                edtusername!!.text?.trim().toString().isNotEmpty()) {*/

                val fname:String = edtfirstname?.text.toString()
                val lname:String = edtlastname?.text.toString()
                val uname:String = edtusername?.text.toString()

                val editor : SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("FirstName",fname)
                editor.putString("LastName",lname)
                editor.putString("UserName",uname)
                editor.apply()

                Toast.makeText(context, "Info Saved", Toast.LENGTH_SHORT).show()

                // replace fragment from one to another
                val fragmentnext = UploadProfileFragment()
                fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragmentnext)?.commit()
                Toast.makeText(context, "input provided", Toast.LENGTH_SHORT).show()
                
           /* }
            else {

                Toast.makeText(context, "input required", Toast.LENGTH_SHORT).show()
            }*/
        }
        return view
    }
}