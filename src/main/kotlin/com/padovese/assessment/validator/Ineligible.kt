package com.padovese.assessment.validator

import com.padovese.assessment.model.RiskProfile
import org.springframework.stereotype.Component

@Component
class Ineligible {
    fun validate(riskProfile: RiskProfile) {
        if(riskProfile.income == 0)
            riskProfile.disabilityScore = Int.MIN_VALUE

        if(riskProfile.houseBinary == 0)
            riskProfile.homeScore = Int.MIN_VALUE

        if(riskProfile.vehicleBinary == 0)
            riskProfile.autoScore = Int.MIN_VALUE

        if(riskProfile.age > 60){
            riskProfile.disabilityScore = Int.MIN_VALUE
            riskProfile.lifeScore = Int.MIN_VALUE
        }
    }
}