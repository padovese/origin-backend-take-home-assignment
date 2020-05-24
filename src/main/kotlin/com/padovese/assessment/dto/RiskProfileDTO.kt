package com.padovese.assessment.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.padovese.assessment.enm.MaritalStatus
import io.swagger.annotations.ApiModelProperty

data class RiskProfileDTO (
        @ApiModelProperty(notes = "age of the client", example = "35")
        val age: Int,
        @ApiModelProperty(notes = "number of dependents", example = "2")
        val dependents: Int,
        val house: HouseDTO?,
        @ApiModelProperty(notes = "no decimals needed", example = "0")
        val income: Int,
        @JsonProperty("marital_status")
        @ApiModelProperty(notes = "single or married", example = "married")
        val maritalStatus: MaritalStatus,
        @JsonProperty("risk_questions")
        @ApiModelProperty(notes = "only 3 values, being 0 or 1", dataType = "List",
                example = "[0,1,0]")
        val riskQuestions: IntArray,
        val vehicle: YearDTO?
)