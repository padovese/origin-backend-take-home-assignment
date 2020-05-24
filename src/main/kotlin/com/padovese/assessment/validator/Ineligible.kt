package com.padovese.assessment.validator

import com.padovese.assessment.model.RiskProfile
import org.springframework.stereotype.Component

@Component
class Ineligible {
    fun validate(riskProfile: RiskProfile) {
        if(riskProfile.income == 0L)
            riskProfile.disabilityScore = Long.MIN_VALUE

        if(riskProfile.houseBinary == 0L)
            riskProfile.homeScore = Long.MIN_VALUE

        if(riskProfile.vehicleBinary == 0L)
            riskProfile.autoScore = Long.MIN_VALUE

        if(riskProfile.age > 60){
            riskProfile.disabilityScore = Long.MIN_VALUE
            riskProfile.lifeScore = Long.MIN_VALUE
        }
    }
}