package com.example.simulation_kotlin

class U2 : Rocket(120, 18000, 29000,0.06, 0.08) {
    init {
        currentWeight = weight
    }

    override fun land(): Boolean {
        return Math.random() >= chanceOfLandingCrash * (currentWeight / (maxWeight - weight))
    }

    override fun launch(): Boolean {
        return Math.random() >= chanceOfLaunchExplosion * (currentWeight / (maxWeight - weight))
    }
}