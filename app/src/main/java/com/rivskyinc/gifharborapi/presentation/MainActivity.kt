package com.rivskyinc.gifharborapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
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

private val component by lazy {
    (this.application as GifApplication).component
}

override fun onCreate(savedInstanceState: Bundle?) {
    component.inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.progressBar.visibility = View.VISIBLE

     val adapter = MyListAdapter(this) { Data ->

            FragmentDetailGif.newInstance(Data.images.original.url)
            launchFragment(FragmentDetailGif())
     }

    binding.progressBar.visibility = View.GONE
    viewModel.gifsListLD.observe(this){
        adapter.submitList(it.data)
    }

}

private fun setupRecyclerView() {
//        binding.recyclerViewMain.apply {
//            myListAdapter = ListAdapter(this, )
//            adapter = myAdapter
//            layoutManager = GridLayoutManager(this.context, 1)
//
        }
    private fun launchFragment(fragment: Fragment) {
             supportFragmentManager.beginTransaction()
            .replace(R.id.activity_constrait, fragment)
            .addToBackStack(null)
            .commit()
    }

}