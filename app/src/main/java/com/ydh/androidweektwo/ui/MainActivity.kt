package com.ydh.androidweektwo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        val navigationController = this.findNavController(R.id.myNavHostFragment)
        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, navigationController, drawerLayout)

//        NavigationUI.setupWithNavController(toolbar, navigationController, appBarConfiguration)

//        binding.navView.setNavigationItemSelectedListener { menuItem ->
//            menuItem.isChecked = true
//            binding.drawerLayout.closeDrawers()
//
//            when (menuItem.itemId) {
//
//                R.id.nav_profile -> {
//                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
//                }
//                R.id.productListFragment -> {
//                    Toast.makeText(this, "Favorite", Toast.LENGTH_LONG).show()
//
////                    NavigationUI.onNavDestinationSelected()
//                }
//                R.id.favoriteFragment -> {
//                    Toast.makeText(this, "Product", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            true
//        }
        navigationController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
        NavigationUI.setupWithNavController(binding.navView, navigationController)

//        binding.navView.bringToFront()

//        setContentView(R.layout.activity_main)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.drawer_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item,
//            requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }


}