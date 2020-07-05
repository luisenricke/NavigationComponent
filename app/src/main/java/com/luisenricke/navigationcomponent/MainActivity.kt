package com.luisenricke.navigationcomponent

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    private val whichStack: Stack = Stack.SEQUENCE

    private val bottomNavigation: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom)
    }

    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment)
            .navController
    }
    private val appBarConfig: AppBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.menu_first, R.id.menu_second, R.id.menu_third))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setupWithNavController(navController)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        bottomNavigation.setOnNavigationItemReselectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true

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

    override fun onNavigationItemReselected(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_first -> navController.popBackStack() // Clears stack if has re-clicked
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        when (whichStack) {
            Stack.HOME -> {
                bottomNavigation.menu.findItem(R.id.menu_first)
                    .takeIf { !it.isChecked }
                    ?.run { isChecked = true }
            }

            Stack.SEQUENCE -> {
                bottomNavigation.selectedItemId = when (navController.currentDestination?.id) {
                    R.id.fragment_first -> bottomNavigation.menu.findItem(R.id.menu_first).itemId
                    R.id.fragment_second -> bottomNavigation.menu.findItem(R.id.menu_second).itemId
                    R.id.fragment_third -> bottomNavigation.menu.findItem(R.id.menu_third).itemId
                    null -> 0.also { Timber.d("Empty stack") }
                    else -> (-1).also { Timber.e("Item doesn't find") }
                }.also { navController.popBackStack() }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

    enum class Stack {
        HOME, SEQUENCE
    }
}
