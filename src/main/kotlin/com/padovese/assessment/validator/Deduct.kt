package com.padovese.assessment.validator

import com.padovese.assessment.model.RiskProfile
import org.springframework.stereotype.Component

@Component
class Deduct {
    fun validate(riskProfile: RiskProfile){
        underThirtyYearsOld(riskProfile)
        betweenThirtyAndFourtyYearsOld(riskProfile)
        moreThanTwoHundredThousandIncome(riskProfile)
    }

    private fun underThirtyYearsOld(riskProfile: RiskProfile){
        if(riskProfile.age < 30){
            riskProfile.disabilityScore -= 2
            riskProfile.homeScore -= 2
            riskProfile.autoScore -= 2
            riskProfile.lifeScore -= 2
        }
    }

    private fun betweenThirtyAndFourtyYearsOld(riskProfile: RiskProfile){
        if(riskProfile.age in 30..40){
            riskProfile.disabilityScore -= 1
            riskProfile.homeScore -= 1
            riskProfile.autoScore -= 1
            riskProfile.lifeScore -= 1
        }
    }

    private fun moreThanTwoHundredThousandIncome(riskProfile: RiskProfile){
        if(riskProfile.income > 200000){
            riskProfile.disabilityScore -= 1
            riskProfile.homeScore -= 1
            riskProfile.autoScore -= 1
            riskProfile.lifeScore -= 1
        }
    }
}