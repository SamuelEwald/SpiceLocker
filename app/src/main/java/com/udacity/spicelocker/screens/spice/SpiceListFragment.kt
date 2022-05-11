package com.udacity.spicelocker.screens.spice

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.spicelocker.R
import com.udacity.spicelocker.databinding.SpiceCardLayoutBinding
import com.udacity.spicelocker.databinding.SpiceListFragmentBinding
import timber.log.Timber

class SpiceListFragment : Fragment() {

    companion object {
        fun newInstance() = SpiceListFragment()
    }

    private val viewModel: SpiceSharedViewModel by activityViewModels()
    private lateinit var binding: SpiceListFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.spice_list_fragment,
            container,
            false
        )

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(SpiceListFragmentDirections.actionSpiceListFragmentToSpiceDetailFragment())
        }


        viewModel.spiceList.observe(viewLifecycleOwner, Observer { spices ->
            spices.forEach {
                val spiceBinding: SpiceCardLayoutBinding =
                    DataBindingUtil.inflate(inflater, R.layout.spice_card_layout, container, false)
                spiceBinding.spice = it
                binding.spiceListLayout.addView(spiceBinding.root)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Timber.w(
            "SpiceList - OnCreateOptionsMenu - Item %s",
            NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
        )
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}