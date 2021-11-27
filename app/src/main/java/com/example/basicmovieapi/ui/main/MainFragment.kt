package com.example.basicmovieapi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.basicmovieapi.databinding.MainFragmentBinding


/**
 * This fragment shows the the status of the Movie web services transaction.
 */
class MainFragment : Fragment() {

    // This fixed thr viewmodels for you, incase you don't get it working the normal way.
    private var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.movieGrid.adapter = ContentGridAdapter()

        binding.title.text = context.toString()

        return binding.root
    }


}









