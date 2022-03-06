package com.example.myapplication

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setBottomNavVisibility()
    }

    private  fun setBottomNavVisibility(){

        navController.addOnDestinationChangedListener{
            controller, destination ,arguments ->
            when(destination.id){
                R.id.navigation_frag_b -> hideBottomNav()
                else -> showBottomNav()
            }
        }

    }

    private fun showBottomNav(){
       findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.VISIBLE
    }

    private fun hideBottomNav(){
        findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.GONE

    }

    /**
     * Cuando este en cualquiera de los fragmentos que tenga el bottom naviftion up
     * que cuando lo apriete fuciona
     */

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_activity_main).navigateUp()
    }
}