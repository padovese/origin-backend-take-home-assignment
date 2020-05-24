package com.padovese.assessment.validator

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.enm.OwnershipStatus
import com.padovese.assessment.exception.NegativeArgException
import com.padovese.assessment.exception.RiskQuestionsException
import com.padovese.assessment.runner.TestRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@RunWith(TestRunner::class)
class PayloadTest {

    @Autowired
    private lateinit var payload: Payload

    @Test(expected = NegativeArgException::class)
    fun `PayloadTest - Negative age`() {
        val riskProfileDTO = RiskProfileDTOMock(-30, 0, 0, intArrayOf(1, 1, 1))
        payload.validate(riskProfileDTO)
    }

    @Test(expected = NegativeArgException::class)
    fun `PayloadTest - Negative dependents`() {
        val riskProfileDTO = RiskProfileDTOMock(30, -1, 0, intArrayOf(1, 1, 1))
        payload.validate(riskProfileDTO)
    }

    @Test(expected = NegativeArgException::class)
    fun `PayloadTest - Negative income`() {
        val riskProfileDTO = RiskProfileDTOMock(30, 0, -1, intArrayOf(1, 1, 1))
        payload.validate(riskProfileDTO)
    }

    @Test(expected = RiskQuestionsException::class)
    fun `PayloadTest - size of risk questions' array different than 3`() {
        val riskProfileDTO = RiskProfileDTOMock(30, 0, 0, intArrayOf(1, 1, 1, 1))
        payload.validate(riskProfileDTO)
    }

    @Test(expected = RiskQuestionsException::class)
    fun `PayloadTest - elements on risk questions array different than 0 or 1`() {
        val riskProfileDTO = RiskProfileDTOMock(30, 0, 0, intArrayOf(-1, 2, 9))
        payload.validate(riskProfileDTO)
    }

    private fun RiskProfileDTOMock(age: Int, dependents: Int, income: Int, riskQuestions: IntArray) =
            RiskProfileDTO(age = age,
                    dependents = dependents,
                    house = HouseDTO(OwnershipStatus.MORTGAGED),
                    income = income,
                    maritalStatus = MaritalStatus.SINGLE,
                    riskQuestions = riskQuestions,
                    vehicle = YearDTO(2020))
}