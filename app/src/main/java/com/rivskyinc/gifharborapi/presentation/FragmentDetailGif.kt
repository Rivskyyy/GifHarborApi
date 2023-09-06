package com.rivskyinc.gifharborapi.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rivskyinc.gifharborapi.databinding.FragmentDetailGifBinding


class FragmentDetailGif : Fragment() {

    private var currentUrl: String? = null

    private lateinit var binding: FragmentDetailGifBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentUrl = it.getString(URL)
            Log.d("Fragment", it.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailGifBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onBackButton.setOnClickListener {
            activity?.onBackPressed()
        }
        setGif()
    }

    private fun setGif() {

        activity?.let {
            Glide.with(it.applicationContext).load(currentUrl).into(binding.gifIvFragmentDetail)
        }
        binding.progressBar.visibility = View.GONE
    }

    companion object {

        const val URL = "url"

        @JvmStatic
        fun newInstance(url: String) =
            FragmentDetailGif().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                }
            }
    }
}