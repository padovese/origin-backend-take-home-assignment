package com.padovese.assessment.enm

import com.fasterxml.jackson.annotation.JsonProperty

enum class OwnershipStatus(val status: String) {
    @JsonProperty("owned")
    OWNED("owned"),
    @JsonProperty("mortgaged")
    MORTGAGED("mortgaged")
}