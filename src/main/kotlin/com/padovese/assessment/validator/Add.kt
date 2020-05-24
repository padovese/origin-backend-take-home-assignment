package com.padovese.assessment.validator

import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.enm.OwnershipStatus
import com.padovese.assessment.model.RiskProfile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class Add {
    fun validate(riskProfile: RiskProfile){
        houseConditions(riskProfile)
        dependentsConditions(riskProfile)
        maritalConditions(riskProfile)
        vehicleConditions(riskProfile)
    }

    private fun vehicleConditions(riskProfile: RiskProfile) {
        if(riskProfile.vehicle != null)
            if(riskProfile.vehicle.year > LocalDate.now().year - 5){
                riskProfile.autoScore += 1
            }
    }

    private fun maritalConditions(riskProfile: RiskProfile) {
        if(riskProfile.maritalStatus == MaritalStatus.MARRIED){
            riskProfile.disabilityScore -= 1
            riskProfile.lifeScore += 1
        }
    }

    private fun dependentsConditions(riskProfile: RiskProfile) {
        if(riskProfile.dependents > 0){
            riskProfile.disabilityScore += 1
            riskProfile.lifeScore += 1
        }
    }

    private fun houseConditions(riskProfile: RiskProfile) {
        if(riskProfile.house?.ownershipStatus == OwnershipStatus.MORTGAGED){
            riskProfile.disabilityScore += 1
            riskProfile.homeScore += 1
        }
    }
}