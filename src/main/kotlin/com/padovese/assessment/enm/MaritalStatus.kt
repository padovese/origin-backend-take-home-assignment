package com.padovese.assessment.enm

import com.fasterxml.jackson.annotation.JsonProperty

enum class MaritalStatus(val status: String) {
    @JsonProperty("single")
    SINGLE("single"),
    @JsonProperty("married")
    MARRIED("married")
}