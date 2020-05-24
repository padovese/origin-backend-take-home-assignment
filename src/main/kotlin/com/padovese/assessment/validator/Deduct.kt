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
            riskProfile.disabilityScore -= 2L
            riskProfile.homeScore -= 2L
            riskProfile.autoScore -= 2L
            riskProfile.lifeScore -= 2L
        }
    }

    private fun betweenThirtyAndFourtyYearsOld(riskProfile: RiskProfile){
        if(riskProfile.age in 30..40){
            riskProfile.disabilityScore -= 1L
            riskProfile.homeScore -= 1L
            riskProfile.autoScore -= 1L
            riskProfile.lifeScore -= 1L
        }
    }

    private fun moreThanTwoHundredThousandIncome(riskProfile: RiskProfile){
        if(riskProfile.income > 200000){
            riskProfile.disabilityScore -= 1L
            riskProfile.homeScore -= 1L
            riskProfile.autoScore -= 1L
            riskProfile.lifeScore -= 1L
        }
    }
}