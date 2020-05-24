package com.padovese.assessment.model

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus

data class RiskProfile(
        val age: Int,
        val dependents: Int,
        val house: HouseDTO?,
        val income: Int,
        val maritalStatus: MaritalStatus,
        val vehicle: YearDTO?,
        var vehicleBinary: Int,
        val houseBinary: Int,
        var autoScore: Int,
        var disabilityScore: Int,
        var homeScore: Int,
        var lifeScore: Int
)