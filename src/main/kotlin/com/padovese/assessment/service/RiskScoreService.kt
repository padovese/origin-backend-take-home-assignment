package com.padovese.assessment.service

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.RiskScoreDTO
import com.padovese.assessment.validator.Payload
import org.springframework.stereotype.Service

@Service
class RiskScoreService (val payload: Payload){

    fun handleRequest(riskProfileDTO: RiskProfileDTO): RiskScoreDTO {
        payload.validate(riskProfileDTO)
        return RiskScoreDTO("regular", "ineligible", "economic", "regular")
    }
}