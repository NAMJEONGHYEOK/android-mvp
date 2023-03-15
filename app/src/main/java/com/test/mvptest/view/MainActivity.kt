package com.test.mvptest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.mvptest.R
import com.test.mvptest.databinding.ActivityMainBinding
import com.test.mvptest.databinding.FragmentLoginBinding

class MainActivity : AppCompatActivity() {
    // fragment에서 뷰바인딩
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // Setting Navigation Controller with the BottomNavigationView
        binding.bottomNav.setupWithNavController(navController)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
        // 첫번째 Fragment를 호출할 때 BottomNavigationView를 숨김
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.LoginFragment) {
                bottomNavigationView.visibility = View.GONE
            } else {
                bottomNavigationView.visibility = View.VISIBLE
            }
        }



    }

    fun HideBottomNavigation(state : Boolean) {
        if (state) binding.bottomNav.visibility =View.GONE else binding.bottomNav.visibility = View.VISIBLE
    }
}