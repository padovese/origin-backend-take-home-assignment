package com.padovese.assessment.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.padovese.assessment.enm.MaritalStatus

data class RiskProfileDTO (
        val age: Int,
        val dependents: Int,
        val house: HouseDTO?,
        val income: Int, //I'll assume no decimals
        @JsonProperty("marital_status")
        val maritalStatus: MaritalStatus,
        @JsonProperty("risk_questions")
        val riskQuestions: IntArray,
        val vehicle: YearDTO?
)