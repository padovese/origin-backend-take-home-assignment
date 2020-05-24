package com.padovese.assessment.model


data class RiskProfile(
        val age: Long,
        val income: Long,
        val baseScore: Long,
        val vehicleScore: Long,
        val houseScore: Long,

        var autoScore: Long = 0L,
        var disabilityScore: Long = 0L,
        var homeScore: Long = 0L,
        var lifeScore: Long = 0L
)