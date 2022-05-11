package com.udacity.spicelocker.screens.login


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.spicelocker.R
import com.udacity.spicelocker.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)



        binding.loginButton.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.registerButton.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }


        return binding.root
    }


}