package com.example.simulation_kotlin

class U1() : Rocket(100, 10000, 18000,0.05, 0.01) {
    init {
        currentWeight = weight
    }

    override fun land(): Boolean {
        return Math.random() >= chanceOfLandingCrash * (currentWeight / (maxWeight - weight))
    }

    override fun launch(): Boolean {
        return Math.random() >= chanceOfLaunchExplosion* (currentWeight / (maxWeight - weight))
    }
}