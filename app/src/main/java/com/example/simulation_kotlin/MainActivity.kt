package com.example.simulation_kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var sumU1: TextView
    lateinit var sumU2: TextView
    var simulation = Simulation(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sumU1 = findViewById(R.id.sumU1)
        sumU2 = findViewById(R.id.sumU2)
    }

    @Throws(Exception::class)
    fun runTheSimulation(view: View?) {
        val totalSumU1 =
            simulation.startSimulation(simulation.loadU1(simulation.readPhaseOne())) +
                    simulation.startSimulation(simulation.loadU1(simulation.readPhaseTwo()))
        val totalSumU2 =
            simulation.startSimulation(simulation.loadU2(simulation.readPhaseOne())) +
                    simulation.startSimulation(simulation.loadU2(simulation.readPhaseTwo()))
        sumU1.text = "$totalSumU1 million $"
        sumU2.text = "$totalSumU2 million $"
    }
}