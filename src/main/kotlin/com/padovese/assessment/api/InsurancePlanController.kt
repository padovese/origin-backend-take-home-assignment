package com.padovese.assessment.api

import com.padovese.assessment.dto.RiskProfileDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InsurancePlanController {

    @PostMapping("/insurance-plan")
    fun insurancePlan(@RequestBody riskProfileDTO: RiskProfileDTO) {
        println(riskProfileDTO)
    }
}