package com.serapercel.saglikliyasam.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.ActivityFlowBinding
import com.serapercel.saglikliyasam.util.createMinuteWorkRequest
class FlowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlowBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val manager = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        navController = manager?.findNavController()!!
        drawerLayout = findViewById(R.id.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        createMinuteWorkRequest("Dik Dur!", 45, this)
        createMinuteWorkRequest("Su iç!", 60, this)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}