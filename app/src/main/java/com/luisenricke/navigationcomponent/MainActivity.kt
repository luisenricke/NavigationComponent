package com.luisenricke.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()/*,
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener*/ {

//    private val whichStack: Stack = Stack.HOME

    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (supportFragmentManager
            .findFragmentById(R.id.fragment_host) as NavHostFragment)
            .navController

        appBarConfig = AppBarConfiguration(
            setOf(R.id.fragment_first, R.id.fragment_second, R.id.fragment_third)
        )

        bottom.setupWithNavController(navController)
//        bottom.setOnNavigationItemSelectedListener(this)
//        bottom.setOnNavigationItemReselectedListener(this)

        this.takeIf { savedInstanceState == null }.also {
            bottom.menu.findItem(R.id.fragment_first).isChecked = true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

//    region without tie destinations to menu items
    /*
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
                bottom.menu.findItem(R.id.fragment_first)
                    .takeIf { !it.isChecked }
                    ?.run { isChecked = true }
            }

            Stack.SEQUENCE -> {
                bottom.selectedItemId = when (navController.currentDestination?.id) {
                    R.id.fragment_first -> bottom.menu.findItem(R.id.fragment_first).itemId
                    R.id.fragment_second -> bottom.menu.findItem(R.id.fragment_second).itemId
                    R.id.fragment_third -> bottom.menu.findItem(R.id.fragment_third).itemId
                    null -> 0.also { Timber.d("Empty stack") }
                    else -> (-1).also { Timber.e("Item doesn't find") }
                }.also { navController.popBackStack() }
            }
        }
    }
*/


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }

//    enum class Stack { HOME, SEQUENCE }

//    endregion
}
