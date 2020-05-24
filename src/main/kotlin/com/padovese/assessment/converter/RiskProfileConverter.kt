package com.padovese.assessment.converter

import com.padovese.assessment.dto.RiskScoreDTO
import com.padovese.assessment.enm.InsurancePlan
import com.padovese.assessment.model.RiskProfile

object RiskProfileConverter {

    fun toRiskScoreDTO(riskProfile: RiskProfile): RiskScoreDTO {
        return RiskScoreDTO(
                auto = mapper(riskProfile.autoScore),
                disability = mapper(riskProfile.disabilityScore),
                home = mapper(riskProfile.homeScore),
                life = mapper(riskProfile.lifeScore)
        )
    }

    private fun mapper(score: Long): String{
        if(score == Long.MIN_VALUE)
            return InsurancePlan.INELIGIBLE.description
        if(score <= 0L)
            return InsurancePlan.ECONOMIC.description
        if(score == 1L || score == 2L)
            return InsurancePlan.REGULAR.description
        if(score >= 3L)
            return InsurancePlan.RESPONSIBLE.description
        return String()
    }
}