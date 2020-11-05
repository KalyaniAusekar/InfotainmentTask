package com.example.infotainmenttask.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.infotainmenttask.Exoplayer
import com.example.infotainmenttask.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.cardview_design.*


open class TrendingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trending, container, false)


        /*val mCardView = view.findViewById<MaterialCardView>(R.id.materialCardView)
        val mCardView2 = view.findViewById<MaterialCardView>(R.id.materialCardView2)
        val mCardView3 = view.findViewById<MaterialCardView>(R.id.materialCardView3)
        val mCardView4 = view.findViewById<MaterialCardView>(R.id.materialCardView4)
        val mCardView5 = view.findViewById<MaterialCardView>(R.id.materialCardView5)
        val mCardView6 = view.findViewById<MaterialCardView>(R.id.materialCardView6)*/


        materialCardView?.setOnClickListener {

            val intent = Intent(activity, Exoplayer::class.java)
            startActivity(intent)
            Toast.makeText(activity,"clicked 1", Toast.LENGTH_SHORT).show()

        }
        materialCardView2?.setOnClickListener {

            val intent2 = Intent(activity, Exoplayer::class.java)
            startActivity(intent2)
           // Toast.makeText(activity,"clicked 2",Toast.LENGTH_SHORT).show()

        }
        materialCardView3?.setOnClickListener {

            val intent2 = Intent(activity, Exoplayer::class.java)
            startActivity(intent2)
           // Toast.makeText(activity,"clicked 3",Toast.LENGTH_SHORT).show()

        }

        materialCardView4?.setOnClickListener {

            val intent4 = Intent(activity, Exoplayer::class.java)
            startActivity(intent4)
        }

        materialCardView5?.setOnClickListener {

            val intent5 = Intent(activity, Exoplayer::class.java)
            startActivity(intent5)
        }

        materialCardView6?.setOnClickListener {

            val intent6 = Intent(activity, Exoplayer::class.java)
            startActivity(intent6)
        }
        return view
    }
}