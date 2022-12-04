package com.example.sherapy.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sherapy.R
import com.example.sherapy.databinding.ActivityMainBinding
import com.example.sherapy.databinding.FragmentHomepageBinding
import com.example.sherapy.utilities.Constants
import com.example.sherapy.utilities.NewsAdapter
import com.example.sherapy.utilities.OnNewsClickListener
import com.example.sherapy.utilities.PreferenceManager
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var preferenceManager: PreferenceManager
    private val newsApiClient = NewsApiClient("abdd96cad11947489f4a80ae0bb9a1a3")
    val newsItem = arrayListOf<Article>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(layoutInflater)

        preferenceManager = PreferenceManager(requireContext())
        binding.imageProfile.setOnClickListener{
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToProfileFragment())
        }
        binding.showmore.setOnClickListener{
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToArticleFragment())
        }
        loadUserDetails()
        fetchNews()
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

    private fun fetchNews() {
        newsApiClient.getEverything(
            EverythingRequest.Builder()
                .q("Mental Health OR Mental Health Issue OR Mental OR Mental health")
                .language("en")
                .build(),
            object: NewsApiClient.ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse?) {
                    response?.articles?.forEach {
                        newsItem.add(it)
                    }
                    bindNews()
                }

                override fun onFailure(throwable: Throwable?) {
                    throwable?.message?.let {
                        Log.e("Error", it)
                        Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                    }
                }
            }
        )
    }

    private fun bindNews() {
        val adapter = NewsAdapter(newsItem, OnNewsClickListener {
            val uri = Uri.parse(it)
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        })
        binding.rvBerita.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBerita.adapter = adapter
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