package com.udacity.spicelocker.screens.instruction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.spicelocker.R
import com.udacity.spicelocker.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    companion object {
        fun newInstance() = InstructionFragment()
    }

    private lateinit var viewModel: InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)

        binding.okButton.setOnClickListener{
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToSpiceListFragment())
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}