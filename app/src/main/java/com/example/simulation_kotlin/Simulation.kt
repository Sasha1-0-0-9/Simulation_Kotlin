package com.example.simulation_kotlin

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException
import java.util.*

class Simulation(var context: Context) {

    @Throws(IOException::class)
    fun readPhaseOne(): ArrayList<Item> {
        val assetManager: AssetManager = context.getAssets()
        val phase_one = ArrayList<Item>()
        val scanner = Scanner(assetManager.open("Phase1"))
        while (scanner.hasNextLine()) {
            val lines = scanner.nextLine().split("=").toTypedArray()
            val item : Item = Item(lines[0], lines[lines.size - 1].toInt())
            phase_one.add(item)
        }
        return phase_one
    }

    @Throws(IOException::class)
    fun readPhaseTwo(): ArrayList<Item> {
        val assetManager = context.assets
        val phase_two = ArrayList<Item>()
        val scanner = Scanner(assetManager.open("Phase2"))
        while (scanner.hasNextLine()) {
            val lines = scanner.nextLine().split("=").toTypedArray()
            val item : Item = Item(lines[0], lines[lines.size - 1].toInt())
            phase_two.add(item)
        }
        return phase_two
    }

    fun loadU1(arrayList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketsPhaseOne = ArrayList<Rocket>()
        var rocket: Rocket = U1()
        for (item in arrayList) {
            if (rocket.canCarry(item)) {
                rocketsPhaseOne.add(rocket)
            } else {
                rocket = U1()
                rocketsPhaseOne.add(rocket)
            }
        }
        return rocketsPhaseOne
    }

    fun loadU2(arrayList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketsPhaseTwo = ArrayList<Rocket>()
        var rocket: Rocket = U2()
        for (item in arrayList) {
            if (rocket.canCarry(item)) {
                rocketsPhaseTwo.add(rocket)
            } else {
                rocket = U2()
                rocketsPhaseTwo.add(rocket)
            }
        }
        return rocketsPhaseTwo
    }

    fun startSimulation(rockets: ArrayList<Rocket>): Int {
        var budget = 0
        for (rocket in rockets) {
            budget += rocket.cost
            while (!rocket.launch() || !rocket.land()) {
                budget += rocket.cost
            }
        }
        return budget
    }
}