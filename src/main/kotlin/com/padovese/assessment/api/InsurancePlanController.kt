package com.padovese.assessment.api

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.RiskScoreDTO
import com.padovese.assessment.service.RiskScoreService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ExampleProperty
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InsurancePlanController(val riskScoreService: RiskScoreService): InsuranceApi {

    @PostMapping("/insurance-plan")
    override fun insurancePlan(@RequestBody riskProfileDTO: RiskProfileDTO) : RiskScoreDTO {
        return riskScoreService.handleRequest(riskProfileDTO)
    }
}