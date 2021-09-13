package com.example.simulation_kotlin

open class Rocket(val cost: Int, val weight: Int, val maxWeight: Int,
                  val chanceOfLaunchExplosion: Double, val chanceOfLandingCrash: Double) : SpaceShip {
    var currentWeight = weight;

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item?): Boolean {
        return currentWeight + weight <= maxWeight
    }

    override fun carry(item: Item?): Int {
        currentWeight += item!!.weight
        return currentWeight
    }
}