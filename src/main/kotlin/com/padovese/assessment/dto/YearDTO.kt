package com.padovese.assessment.dto

import io.swagger.annotations.ApiModelProperty

data class YearDTO(
        @ApiModelProperty(notes = "Year the car was made.", example = "2018")
        val year: Int
)