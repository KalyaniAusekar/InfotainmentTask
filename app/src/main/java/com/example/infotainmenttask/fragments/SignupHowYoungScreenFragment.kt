package com.example.infotainmenttask.fragments

import android.content.Context
import android.content.SharedPreferences
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.infotainmenttask.R
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class SignupHowYoungScreenFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        sharedPreferences = context!!.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

        auth = FirebaseAuth.getInstance()

        val view = inflater.inflate(R.layout.fragment_signup_how_young_screen, container, false)

        val txthowyoung = view.findViewById<MaterialTextView>(R.id.txt_how_young_are)
        val txtyou = view.findViewById<MaterialTextView>(R.id.txt_you)

        val txtyearsold = view.findViewById<MaterialTextView>(R.id.txt_years_old)
        val txtor = view.findViewById<MaterialTextView>(R.id.txt_or)

        val edtagenum = view.findViewById<TextInputEditText>(R.id.edt_age_number)
        val edt_mobile = view.findViewById<TextInputEditText>(R.id.edt_mobile_number)

        val edtemail = view.findViewById<TextInputEditText>(R.id.edt_email_user)
        val edtpass = view.findViewById<TextInputEditText>(R.id.edt_email_user_password)

        val btnNextScreen = view.findViewById<MaterialButton>(R.id.btn_how_young_next)

        btnNextScreen.setOnClickListener {

            if (edtagenum!!.text?.trim().toString().isNotEmpty() ||
                edt_mobile!!.text?.trim().toString().isNotEmpty() ||
                edtemail!!.text?.trim().toString().isNotEmpty() ||
                edtpass!!.text?.trim().toString().isNotEmpty()
            ) {

                Toast.makeText(context, "input provided", Toast.LENGTH_SHORT).show()
                val age = edtagenum.text!!
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("Age", age.toString())
                editor.apply()

                createUser(edtemail.text?.trim().toString(), edtpass.text?.trim().toString())


            } else {

                Toast.makeText(context, "input required", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun createUser(email: String, password: String) {

        this.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task: Task<AuthResult> ->

                if (task.isSuccessful) {

                    val fragmentotp = OtpConfirmFragment()
                    fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragmentotp)
                        ?.commit()
                    Log.e("task message", "Successful")
                } else {

                    Log.e("task message", "failed..." + task.exception)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser

        if(user != null) {

            // replace fragment from one to anthero
            val fragmentotp = OtpConfirmFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragmentotp)
                ?.commit()
        }
    }
}