package com.example.infotainmenttask

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.infotainmenttask.fragments.OtpConfirmFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


         val we_are_glad_txt = findViewById<MaterialTextView>(R.id.materialTextView)
        // val face1 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        // we_are_glad_txt.setTypeface(face1)

         val to_have_you = findViewById<MaterialTextView>(R.id.materialTextView2)
         //val face2 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        // to_have_you.setTypeface(face2)

         val again = findViewById<MaterialTextView>(R.id.materialTextView3)
        // val face3 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
         //again.setTypeface(face3)

        val btn_login = findViewById<MaterialButton>(R.id.btn_login)
        //val btn_login_font = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        //btn_login.setTypeface(btn_login_font)

        btn_login?.setOnClickListener() {

            if (edt_username_login.text?.trim().toString()
                    .isNotEmpty() || edt_password_login.text?.trim().toString().isNotEmpty()
            ) {

                SignInUser(
                    edt_username_login.text?.trim().toString(),
                    edt_password_login.text?.trim().toString()
                )
            } else {

                Toast.makeText(this, "input required", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun SignInUser(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser

        if(user != null) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}