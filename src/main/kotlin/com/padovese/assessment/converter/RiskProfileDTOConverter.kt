package com.padovese.assessment.converter

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.model.RiskProfile

object RiskProfileDTOConverter {

    fun toRiskProfile(riskProfileDTO: RiskProfileDTO) : RiskProfile{
        return RiskProfile(
                age = riskProfileDTO.age,
                income = riskProfileDTO.income,
                baseScore = riskProfileDTO.riskQuestions.sum().toLong(),
                vehicleScore = if(riskProfileDTO.vehicle != null) 1L else 0L,
                houseScore = if(riskProfileDTO.house != null) 1L else 0L
        )
    }
}