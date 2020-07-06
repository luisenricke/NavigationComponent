package com.luisenricke.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()/*,
    NavigationView.OnNavigationItemSelectedListener*/ {

//    private val whichStack: Stack = Stack.SEQUENCE

    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        navController = (supportFragmentManager
            .findFragmentById(R.id.fragment_host) as NavHostFragment)
            .navController

        appBarConfig = AppBarConfiguration(
            // navController.graph, drawer
            setOf(R.id.fragment_first, R.id.fragment_second, R.id.fragment_third), drawer
        )

        setupActionBarWithNavController(this, navController, appBarConfig)
        navigation.setupWithNavController(navController)
//        navigation.setNavigationItemSelectedListener(this)

        this.takeIf { savedInstanceState == null }.also {
            navigation.menu.findItem(R.id.fragment_first).isChecked = true
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

//    region without tie destinations to menu items
/*
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawer.closeDrawers()

        if (whichStack == Stack.HOME) {
            navController.apply { popBackStack(R.id.fragment_first, false) }
                .takeIf { item.itemId == R.id.menu_first }
                .also { it?.popBackStack() }
        }

        when (item.itemId) {
            R.id.menu_first -> navController.navigate(R.id.fragment_first)
            R.id.menu_second -> navController.navigate(R.id.fragment_second)
            R.id.menu_third -> navController.navigate(R.id.fragment_third)
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

            val idSelected = when (navController.currentDestination?.id) {
                R.id.fragment_first -> navigation.menu.findItem(R.id.menu_first).itemId
                R.id.fragment_second -> navigation.menu.findItem(R.id.menu_second).itemId
                R.id.fragment_third -> navigation.menu.findItem(R.id.menu_third).itemId
                null -> 0.also { Timber.d("Empty stack") }
                else -> (-1).also { Timber.e("Item doesn't find") }
            }

            navigation.menu.findItem(idSelected).isChecked = true
        }
    }
 */

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }

//    enum class Stack { HOME, SEQUENCE }

//    endregion
}
