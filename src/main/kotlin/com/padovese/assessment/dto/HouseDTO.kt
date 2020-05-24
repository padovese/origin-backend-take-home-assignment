package com.padovese.assessment.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.padovese.assessment.enm.OwnershipStatus
import io.swagger.annotations.ApiModelProperty

data class HouseDTO (
        @JsonProperty("ownership_status")
        @ApiModelProperty(notes = "owned or mortgaged", example = "owned")
        val ownershipStatus: OwnershipStatus
)