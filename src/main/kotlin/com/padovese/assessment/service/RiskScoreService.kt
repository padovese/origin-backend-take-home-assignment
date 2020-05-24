package com.padovese.assessment.service

import com.padovese.assessment.converter.RiskProfileConverter
import com.padovese.assessment.converter.RiskProfileDTOConverter
import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.RiskScoreDTO
import com.padovese.assessment.enm.InsurancePlan
import com.padovese.assessment.model.RiskProfile
import com.padovese.assessment.validator.Ineligible
import com.padovese.assessment.validator.Payload
import org.springframework.stereotype.Service

@Service
class RiskScoreService (val payload: Payload,
                        val ineligible: Ineligible){

    fun handleRequest(riskProfileDTO: RiskProfileDTO): RiskScoreDTO {
        payload.validate(riskProfileDTO)

        val riskProfile: RiskProfile = RiskProfileDTOConverter.toRiskProfile(riskProfileDTO)
        ineligible.validate(riskProfile)

        return RiskProfileConverter.toRiskScoreDTO(riskProfile)
    }


}