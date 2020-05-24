package com.padovese.assessment.validator

import com.padovese.assessment.model.RiskProfile
import org.springframework.stereotype.Component

@Component
class IncomeConditions {
    fun validate(riskProfile: RiskProfile) {
        if(riskProfile.income > 200000){
            riskProfile.disabilityScore -= 1L
            riskProfile.homeScore -= 1L
            riskProfile.autoScore -= 1L
            riskProfile.lifeScore -= 1L
        }
    }
}
