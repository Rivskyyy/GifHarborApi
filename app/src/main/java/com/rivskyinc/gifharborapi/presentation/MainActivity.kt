package com.rivskyinc.gifharborapi.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rivskyinc.gifharborapi.R
import com.rivskyinc.gifharborapi.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private lateinit var myAdapter: MyListAdapter

    private val component by lazy {
        (this.application as GifApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        binding.progressBar.visibility = View.VISIBLE
        myAdapter.onClickListener = {
            val detailFragment = FragmentDetailGif.newInstance(it.images.original.url)
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(
                    R.id.activity_constrait,
                    detailFragment
                )
                .addToBackStack(null)
                .commit()
        }



        binding.progressBar.visibility = View.GONE

        viewModel.gifsListLD.observe(this) {
            if ( it!= null ){
                myAdapter.submitList(it.data)
            } else {
                binding.progressBar.visibility = View.VISIBLE
                Toast.makeText(this, "No Internet connection", Toast.LENGTH_LONG).show()
            }


        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewMain.apply {
            myAdapter = MyListAdapter()
            adapter = myAdapter
            layoutManager = GridLayoutManager(context, 1)

        }
    }


    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_constrait, fragment)
            .addToBackStack(null)
            .commit()
    }

}