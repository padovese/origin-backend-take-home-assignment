package com.padovese.assessment.api

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.RiskScoreDTO
import com.padovese.assessment.service.RiskScoreService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InsurancePlanController(val riskScoreService: RiskScoreService) {

    @PostMapping("/insurance-plan")
    fun insurancePlan(@RequestBody riskProfileDTO: RiskProfileDTO) : RiskScoreDTO {
        return riskScoreService.handleRequest(riskProfileDTO)
    }
}