package com.padovese.assessment.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.padovese.assessment.enm.MaritalStatus

data class RiskProfileDTO (
        val age: Long,
        val dependents: Long,
        val house: HouseDTO,
        val income: Long,
        @JsonProperty("marital_status")
        val maritalStatus: MaritalStatus,
        @JsonProperty("risk_questions")
        val riskQuestions: IntArray,
        val vehicle: YearDTO
)