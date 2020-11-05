package com.example.infotainmenttask

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.infotainmenttask.fragments.SignupHowYoungScreenFragment
import com.example.infotainmenttask.fragments.StartWithbasicsFragment
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        setContentView(R.layout.activity_sign_up)

        val fragmentone = StartWithbasicsFragment()

        /*val txt_lets_start = findViewById<MaterialTextView>(R.id.txt_lets_start)
        val face1 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        txt_lets_start.setTypeface(face1)


        val txt_basics = findViewById<MaterialTextView>(R.id.txt_with_basics)
        val face2 = Typeface.createFromAsset(assets, "OpenSans-SemiBold.ttf")
        txt_basics.setTypeface(face2)
*/
        // fragment add on activity
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragmentone).commit()

    }

}