package com.udacity.spicelocker.screens.instruction

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

}