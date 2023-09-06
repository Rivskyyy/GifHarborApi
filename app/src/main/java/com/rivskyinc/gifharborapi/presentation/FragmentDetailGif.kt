package com.rivskyinc.gifharborapi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rivskyinc.gifharborapi.R
import com.rivskyinc.gifharborapi.databinding.FragmentDetailGifBinding


class FragmentDetailGif : Fragment() {
    // TODO: Rename and change types of parameters
    private var currentUrl: String? = null


    private lateinit var binding: FragmentDetailGifBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentUrl = it.getString(URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailGifBinding.inflate(layoutInflater, container, false )
        return binding.root
    }

    companion object {

        const val URL = "url"
        @JvmStatic
        fun newInstance(url: String,)
        =
            FragmentDetailGif().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                }
            }
    }
}