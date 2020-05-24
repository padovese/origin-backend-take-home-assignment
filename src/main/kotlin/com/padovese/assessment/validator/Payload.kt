package com.padovese.assessment.validator

import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.exception.NegativeArgException
import com.padovese.assessment.exception.RiskQuestionsException
import org.springframework.stereotype.Component

@Component
class Payload {

    fun validate(riskProfileDTO: RiskProfileDTO) {
        if(riskProfileDTO.age < 0)
            throw NegativeArgException("age", riskProfileDTO.age)

        if(riskProfileDTO.dependents < 0)
            throw NegativeArgException("dependents", riskProfileDTO.dependents)

        if(riskProfileDTO.income < 0)
            throw NegativeArgException("income", riskProfileDTO.income)

        if (riskProfileDTO.riskQuestions.size != 3)
            throw RiskQuestionsException()

        riskProfileDTO.riskQuestions.map { i -> if(i == 0 || i == 1) else throw RiskQuestionsException() }
    }
}