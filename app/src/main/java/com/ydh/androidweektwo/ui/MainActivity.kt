package com.ydh.androidweektwo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        val navigationController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navigationController)

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            binding.drawerLayout.closeDrawers()

            when (menuItem.itemId) {

                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                }
                R.id.nav_favorite -> {
                    Toast.makeText(this, "Favorite", Toast.LENGTH_LONG).show()
                }
                R.id.nav_product -> {
                    Toast.makeText(this, "Product", Toast.LENGTH_LONG).show()
                }
            }

            true
        }

//        setContentView(R.layout.activity_main)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}