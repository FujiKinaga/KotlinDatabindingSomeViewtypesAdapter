package com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fujikinaga.kotlindatabindingsomeviewtypesadapter.ad.AdViewModel
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val viewModel = ViewModelProviders.of(this).get(AdViewModel::class.java)
        lifecycle.addObserver(viewModel)
        // アドジェネのメディエーション配信がActivityのインスタンスを期待しているため、Activity Contextを渡す
        viewModel.initAdViewList(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
