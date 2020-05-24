package com.padovese.assessment.model

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus


data class RiskProfile(
        val age: Long,
        val dependents: Long,
        val house: HouseDTO?,
        val income: Long,
        val maritalStatus: MaritalStatus,
        val vehicle: YearDTO?,
        var vehicleBinary: Long,
        val houseBinary: Long,
        var autoScore: Long,
        var disabilityScore: Long,
        var homeScore: Long,
        var lifeScore: Long
)