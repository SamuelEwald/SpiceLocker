package com.udacity.spicelocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.spicelocker.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())


        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment!!.findNavController()

        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.loginFragment,
            R.id.welcomeFragment,
            R.id.spiceListFragment
        ).build()
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)




    }



}
