package com.luisenricke.navigationcomponent

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navController: NavController
    lateinit var navigationView: NavigationView

    lateinit var appConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        navigationView = findViewById<NavigationView>(R.id.navigationView)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        appConfig = AppBarConfiguration
            .Builder(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment))
            .setDrawerLayout(drawerLayout).build()

        NavigationUI.setupActionBarWithNavController(this, navController, appConfig)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appConfig)
                || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawerLayout.closeDrawers()

        when (item.itemId) {
            R.id.first -> {
                Log.i("Activity", "First")
                navController.navigate(R.id.firstFragment)
                //navController.popBackStack()
                //navController.popBackStack(R.id.secondFragment,true)
            }
            R.id.second -> {
                Log.i("Activity", "Second")
                navController.navigate(R.id.secondFragment)
            }
            R.id.third -> {
                Log.i("Activity", "Third")
                navController.navigate(R.id.thirdFragment)
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

}
