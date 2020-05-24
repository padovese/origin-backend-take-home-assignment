package com.padovese.assessment.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.padovese.assessment.enm.OwnershipStatus

data class HouseDTO (
        @JsonProperty("ownership_status")
        val ownershipStatus: OwnershipStatus
)