package com.example.sherapy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sherapy.R
import com.example.sherapy.databinding.ActivityMainBinding
import com.example.sherapy.databinding.FragmentHomepageBinding
import com.example.sherapy.utilities.Constants
import com.example.sherapy.utilities.PreferenceManager

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(layoutInflater)

        preferenceManager = PreferenceManager(requireContext())

        loadUserDetails()
//        getToken()
//        setListeners()

        return binding.root
    }

//    private fun setListeners() {
//        binding.imageSignOut.setOnClickListener { signOut() }
//    }

    private fun loadUserDetails() {
        binding.textName.text = preferenceManager.getString(Constants.KEY_NAME)

//        val bytes: ByteArray = Base64.decode(preferenceManager.getString(Constants.KEY_IMAGE), Base64.DEFAULT)
//        val bitmap: Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//        binding.imageProfile.setImageBitmap(bitmap)
    }

//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }

//    private fun getToken() {
//        FirebaseMessaging.getInstance().token.addOnSuccessListener(this::updateToken)
//    }

//    private fun updateToken(token: String) {
//        val database: FirebaseFirestore = FirebaseFirestore.getInstance()
//        val documentReference: DocumentReference =
//            database.collection(Constants.KEY_COLLECTION_USERS).document(
//                preferenceManager.getString(Constants.KEY_USER_ID)!!
//            )
//        documentReference.update(Constants.KEY_FCM_TOKEN, token)
//            .addOnSuccessListener { showToast("Token Updated Successfully") }
//            .addOnFailureListener { showToast("Unable to update token") }
//    }

//    private fun signOut() {
//        showToast("Sign out ...")
//        val database: FirebaseFirestore = FirebaseFirestore.getInstance()
//        val documentReference: DocumentReference = database.collection(Constants.KEY_COLLECTION_USERS).document(
//            preferenceManager.getString(Constants.KEY_USER_ID)!!
//        )
//
//        val updates = hashMapOf(
//            Constants.KEY_FCM_TOKEN to FieldValue.delete()
//        )
//        documentReference.update(updates as Map<String, Any>)
//            .addOnSuccessListener { unused ->
//                preferenceManager.clear()
//                startActivity(Intent(applicationContext, SignInActivity::class.java))
//                finish()
//            }
//            .addOnFailureListener { e -> showToast("Unable to sign out") }
//    }
}