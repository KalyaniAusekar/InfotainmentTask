package com.example.infotainmenttask

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textview.MaterialTextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        setContentView(R.layout.activity_home)

        val txt_out = findViewById<MaterialTextView>(R.id.textView2)
        val face_txt1 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        txt_out.setTypeface(face_txt1)

        val txt_of = findViewById<MaterialTextView>(R.id.textView3)
        val face_txt2 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        txt_of.setTypeface(face_txt2)

        val txt_control = findViewById<MaterialTextView>(R.id.textView4)
        val face_txt4 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        txt_control.setTypeface(face_txt4)

        val materialButton_already_a_member = findViewById<MaterialButton>(R.id.mbtn_already_a_member)
        val face = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        materialButton_already_a_member.setTypeface(face)

        val materialButton_Sign_up = findViewById<MaterialButton>(R.id.btn_sign_up)
        val face1 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        materialButton_Sign_up.setTypeface(face1)

        val materialButton_fb = findViewById<MaterialButton>(R.id.btn_fb)
        val face2 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        materialButton_fb.setTypeface(face2)

        materialButton_already_a_member?.setOnClickListener() {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        materialButton_Sign_up?.setOnClickListener() {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
        materialButton_fb?.setOnClickListener() {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}