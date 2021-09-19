package com.example.simulation_kotlin

open class Rocket(val cost: Int, val weight: Int, val maxWeight: Int,
                  val chanceOfLaunchExplosion: Double, val chanceOfLandingCrash: Double) : SpaceShip {
    var currentWeight = weight;

    override fun launch(): Boolean = true

    override fun land(): Boolean = true

    override fun canCarry(item: Item): Boolean = currentWeight + item.weight <= maxWeight

    override fun carry(item: Item): Int {
        currentWeight += item.weight
        return currentWeight
    }
}