package com.padovese.assessment.converter

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.model.RiskProfile

object RiskProfileDTOConverter {

    fun toRiskProfile(riskProfileDTO: RiskProfileDTO) : RiskProfile{
        val baseScore = riskProfileDTO.riskQuestions.sum()

        return RiskProfile(
                age = riskProfileDTO.age,
                income = riskProfileDTO.income,
                house = riskProfileDTO.house,
                dependents = riskProfileDTO.dependents,
                maritalStatus = riskProfileDTO.maritalStatus,
                vehicle = riskProfileDTO.vehicle,
                vehicleBinary = if(riskProfileDTO.vehicle != null) 1 else 0,
                houseBinary = if(riskProfileDTO.house != null) 1 else 0,
                autoScore = baseScore,
                disabilityScore = baseScore,
                homeScore = baseScore,
                lifeScore = baseScore
        )
    }
}