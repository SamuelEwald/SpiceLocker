package com.udacity.spicelocker.screens.spice


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.spicelocker.R
import com.udacity.spicelocker.databinding.SpiceDetailFragmentBinding
import com.udacity.spicelocker.models.Spice
import timber.log.Timber

class SpiceDetailFragment : Fragment() {
    private val viewModel: SpiceSharedViewModel by activityViewModels()
    private lateinit var binding: SpiceDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.spice_detail_fragment, container, false)
        binding.spiceSharedViewModel = viewModel
        binding.spice = Spice(
            "Tumeric",
            "g",
            250.0,
            60.0,
            "Generic",
            "Ground Tumeric"
        )

        binding.cancelButton.setOnClickListener{
            Log.i("SpiceDetailFragment", "Cancel Button Clicked")
            findNavController().navigateUp()
        }

        return inflater.inflate(R.layout.spice_detail_fragment, container, false)
    }
}