package com.example.infotainmenttask.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.infotainmenttask.R
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_upload_profile.*
import kotlinx.android.synthetic.main.fragment_upload_profile.view.*
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest


class UploadProfileFragment : Fragment() {

    private var imguploadprofile: CircleImageView? = null
    private var btnconfirm: MaterialButton? = null
    private var txtback: MaterialTextView? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_upload_profile, container, false)
        btnconfirm = view.findViewById<MaterialButton>(R.id.btn_upload_profile_confirm) as MaterialButton
        txtback = view.findViewById<MaterialTextView>(R.id.txt_upload_back) as MaterialTextView
        imguploadprofile = view.findViewById<CircleImageView>(R.id.img_upload_profile) as CircleImageView


        if (ActivityCompat.checkSelfPermission(context!!,android.Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity!!, arrayOf(android.Manifest.permission.CAMERA),11)
        }

        view.img_upload_profile.setOnClickListener {

            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,101)
        }

        btnconfirm!!.setOnClickListener {

            // replace fragment from one to another
            val fragmentdetails = SignupHowYoungScreenFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragmentdetails)?.commit()

        }

       /* txtback!!.setOnClickListener {

                // replace fragment from one to another
            val basicfragment = StartWithbasicsFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, basicfragment)?.commit()

        }
*/
        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==101) {

           var bitmap : Bitmap = data?.getParcelableExtra<Bitmap>("data")!!
            imguploadprofile?.setImageBitmap(bitmap)
        }
    }
}
