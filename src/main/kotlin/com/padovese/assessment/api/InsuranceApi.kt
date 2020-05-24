package com.padovese.assessment.api

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.RiskScoreDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestBody

@Api(description = "Api responsible for calculate the plans, given a risk profile.", tags = ["insurance-plans"])
interface InsuranceApi {

    @ApiOperation(value = "Post a profile and give back the plans.", nickname = "insurance-plans")
    fun insurancePlan(@RequestBody riskProfileDTO: RiskProfileDTO) : RiskScoreDTO
}